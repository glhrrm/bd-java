package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import pojo.Permissao;
import teste.ConnectionFactory;

public class PermissaoDAO implements DAO<Permissao> {

    @Override
    public int insert(Permissao p) {
        int chavePrimaria = -1;
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.INSERT_PERMISSAO.getSql(), Statement.RETURN_GENERATED_KEYS)) {

            System.out.println("Conexão aberta!");

            stmt.setString(1, p.getNome());

            stmt.execute();

            System.out.println("Dados Gravados!");

            ResultSet chaves = stmt.getGeneratedKeys();

            if (chaves.next()) {
                //chavePrimaria = chaves.getInt(1);
                chavePrimaria = 1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Exceção com recursos");
        }
        return chavePrimaria;
    }

    @Override
    public List<Permissao> listAll() {
        List<Permissao> permissoes = new LinkedList<>();
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.LISTALL_PERMISSAO.getSql())) {

            System.out.println("Conexão aberta!");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_Permissao");
                String nome = rs.getString("nome");
                permissoes.add(new Permissao(id, nome));
            }

            return permissoes;
        } catch (SQLException ex) {
            System.out.println("Exceção de SQL.");
        }
        return null;
    }

    @Override
    public int update(Permissao p) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.UPDATE_PERMISSAO.getSql())) {

            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getIdPermissao());

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
                PreparedStatement stmt = connection.prepareStatement(SQLs.DELETE_PERMISSAO.getSql())) {

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
    public Permissao findById(int id) {
        Permissao p = null;
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.FINDBYID_PERMISSAO.getSql())) {

            stmt.setInt(1, id);

            System.out.println("Conexão aberta!");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                p = new Permissao(id, nome);
            }
        } catch (SQLException ex) {
            System.out.println("Exceção SQL - findById");
        } catch (Exception ex) {
            System.out.println("Exceção no código!- findById");
        }
        return p;
    }

    public Permissao find(Connection connection, int idPermissao) {
        try {
            PreparedStatement stmt = connection.prepareStatement(SQLs.FINDBYID_PERMISSAO.getSql());

            stmt.setInt(1, idPermissao);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                return new Permissao(nome);
            }
        } catch (SQLException e) {
            System.out.println("Exceção find PeriodoDAO");
        }
        return null;
    }

}
