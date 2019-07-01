package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import pojo.Sistema;
import pojo.Usuario;
import teste.ConnectionFactory;

public class SistemaDAO implements DAO<Sistema> {

    @Override
    public int insert(Sistema s) {
        int chavePrimaria = -1;
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.INSERT_SISTEMA.getSql(), Statement.RETURN_GENERATED_KEYS)) {

            System.out.println("Conexão aberta!");

            stmt.setInt(1, (s.isAtivo() == true) ? 1 : 0);
            stmt.setDate(2, Date.valueOf(s.getCriacao()));
            stmt.setInt(3, s.getUsuario().getIdUsuario());

            stmt.execute();

            System.out.println("Dados Gravados!");

            ResultSet chaves = stmt.getGeneratedKeys();

            if (chaves.next()) {
                chavePrimaria = chaves.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Exceção com recursos");
        }
        return chavePrimaria;
    }

    @Override
    public List<Sistema> listAll() {
        List<Sistema> sistemas = new LinkedList<>();
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.LISTALL_SISTEMA.getSql())) {

            System.out.println("Conexão aberta!");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idSistema");
                boolean ativo = (rs.getInt("ativo") == 1) ? true : false;
                LocalDate criacao = rs.getDate("criacao").toLocalDate();
                Usuario usuario = new UsuarioDAO().find(connection, rs.getInt("idUsuario"));
                sistemas.add(new Sistema(id, ativo, criacao, usuario));
            }

            return sistemas;
        } catch (SQLException ex) {
            System.out.println("Exceção de SQL.");
        }
        return null;
    }

    @Override
    public int update(Sistema s) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.UPDATE_SISTEMA.getSql())) {

            stmt.setInt(1, s.isAtivo() ? 1 : 0);
            stmt.setDate(2, Date.valueOf(s.getCriacao()));
            stmt.setInt(3, s.getUsuario().getIdUsuario());
            stmt.setInt(4, s.getIdSistema());

            System.out.println("Conexão aberta!");

            if (stmt.execute()) {
                return 1;
            }
        } catch (SQLException ex) {
            System.out.println("Exceção SQL - update");
        } catch (Exception ex) {
            System.out.println("Exceção no código! - update");
        }
        return -1;
    }

    @Override
    public int delete(int id) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.DELETE_SISTEMA.getSql())) {

            stmt.setInt(1, id);

            System.out.println("Conexão aberta!");

            if (stmt.execute()) {
                return 1;
            }
        } catch (SQLException ex) {
            System.out.println("Exceção SQL - delete");
        } catch (Exception ex) {
            System.out.println("Exceção no código! - delete");
        }
        return -1;
    }

    @Override
    public Sistema findById(int id) {
        Sistema s;
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.FINDBYID_SISTEMA.getSql())) {

            stmt.setInt(1, id);

            System.out.println("Conexão aberta!");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                boolean ativo = (rs.getInt("ativo") == 1) ? true : false;
                LocalDate criacao = rs.getDate("criacao").toLocalDate();
                Usuario usuario = new UsuarioDAO().find(connection, rs.getInt("idUsuario"));
                s = new Sistema(id, ativo, criacao, usuario);
            }
        } catch (SQLException ex) {
            System.out.println("Exceção SQL - findById");
        } catch (Exception ex) {
            System.out.println("Exceção no código!- findById");
        }
        return null;
    }
    
    public Sistema find(Connection connection, int idSistema) {
        try {
            PreparedStatement stmt = connection.prepareStatement(SQLs.FINDBYID_SISTEMA.getSql());

            stmt.setInt(1, idSistema);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                boolean ativo = (rs.getInt("ativo") == 1) ? true : false;
                LocalDate criacao = rs.getDate("criacao").toLocalDate();
                Usuario usuario = new UsuarioDAO().find(connection, rs.getInt("idUsuario"));
                return new Sistema(idSistema, ativo, criacao, usuario);
            }
        } catch (SQLException e) {
            System.out.println("Exceção find PeriodoDAO");
        }
        return null;
    }

}
