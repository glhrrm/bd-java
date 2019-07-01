package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import pojo.Departamento;
import teste.ConnectionFactory;

public class DepartamentoDAO implements DAO<Departamento> {

    @Override
    public int insert(Departamento d) {
        int chavePrimaria = -1;
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.INSERT_DEPARTAMENTO.getSql(), Statement.RETURN_GENERATED_KEYS)) {

            System.out.println("Conexão aberta!");

            stmt.setString(1, d.getNome());

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
    public List<Departamento> listAll() {
        List<Departamento> departamentos = new LinkedList<>();
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.LISTALL_DEPARTAMENTO.getSql())) {

            System.out.println("Conexão aberta!");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idDepartamento");
                String nome = rs.getString("nome");
                departamentos.add(new Departamento(id, nome));
            }

            return departamentos;
        } catch (SQLException ex) {
            System.out.println("Exceção de SQL.");
        }
        return null;
    }

    @Override
    public int update(Departamento d) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.UPDATE_DEPARTAMENTO.getSql())) {

            stmt.setString(1, d.getNome());
            stmt.setInt(2, d.getIdDepartamento());

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
                PreparedStatement stmt = connection.prepareStatement(SQLs.DELETE_DEPARTAMENTO.getSql())) {

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
    public Departamento findById(int id) {
        Departamento d;
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.FINDBYID_DEPARTAMENTO.getSql())) {

            stmt.setInt(1, id);

            System.out.println("Conexão aberta!");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                d = new Departamento(id, nome);
            }
        } catch (SQLException ex) {
            System.out.println("Exceção SQL - findById");
        } catch (Exception ex) {
            System.out.println("Exceção no código!- findById");
        }
        return null;
    }

    public Departamento find(Connection connection, int idDepartamento) {
        try {
            PreparedStatement stmt = connection.prepareStatement(SQLs.FINDBYID_DEPARTAMENTO.getSql());

            stmt.setInt(1, idDepartamento);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                return new Departamento(idDepartamento, nome);
            }
        } catch (SQLException e) {
            System.out.println("Exceção find PeriodoDAO");
        }
        return null;
    }

}
