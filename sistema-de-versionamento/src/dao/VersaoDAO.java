package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import pojo.Sistema;
import pojo.Versao;
import teste.ConnectionFactory;

public class VersaoDAO implements DAO<Versao> {

    @Override
    public int insert(Versao v) {
        int chavePrimaria = -1;
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.INSERT_VERSAO.getSql(), Statement.RETURN_GENERATED_KEYS)) {

            System.out.println("Conexão aberta!");

            stmt.setString(1, v.getVersao());
            stmt.setString(2, v.getNovidades());
            stmt.setInt(3, v.getSistema().getIdSistema());

            stmt.execute();

            System.out.println("Dados Gravados!");

            ResultSet chaves = stmt.getGeneratedKeys();

            if (chaves.next()) {
                chavePrimaria = chaves.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Exceção com recursos");
        }
        return chavePrimaria;
    }

    @Override
    public List<Versao> listAll() {
        List<Versao> versoes = new LinkedList<>();
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.LISTALL_VERSAO.getSql())) {

            System.out.println("Conexão aberta!");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idVersao");
                String versao = rs.getString("versao");
                String novidades = rs.getString("novidades");
                Sistema sistema = new SistemaDAO().find(connection, rs.getInt("idSistema"));
                versoes.add(new Versao(id, versao, novidades, sistema));
            }

            return versoes;
        } catch (SQLException ex) {
            System.out.println("Exceção de SQL.");
        }
        return null;
    }

    @Override
    public int update(Versao v) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.UPDATE_VERSAO.getSql())) {

            stmt.setString(1, v.getVersao());
            stmt.setString(2, v.getNovidades());
            stmt.setInt(3, v.getSistema().getIdSistema());
            stmt.setInt(4, v.getIdVersao());

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
                PreparedStatement stmt = connection.prepareStatement(SQLs.DELETE_VERSAO.getSql())) {

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
    public Versao findById(int id) {
        Versao v;
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.FINDBYID_VERSAO.getSql())) {

            stmt.setInt(1, id);

            System.out.println("Conexão aberta!");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String versao = rs.getString("versao");
                String novidades = rs.getString("novidades");
                Sistema sistema = new SistemaDAO().find(connection, rs.getInt("idSistema"));
                v = new Versao(id, versao, novidades, sistema);
            }
        } catch (SQLException ex) {
            System.out.println("Exceção SQL - findById");
        } catch (Exception ex) {
            System.out.println("Exceção no código!- findById");
        }
        return null;
    }

}
