package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import pojo.Departamento;
import pojo.Permissao;
import pojo.Usuario;
import teste.ConnectionFactory;

public class UsuarioDAO implements DAO<Usuario> {

    @Override
    public int insert(Usuario u) {
        int chavePrimaria = -1;
        int idDepartamento = new DepartamentoDAO().insert(u.getDepartamento());
        int idPermissao = new PermissaoDAO().insert(u.getPermissao());
        if (idDepartamento == -1 || idPermissao == -1) {
            return -1;
        }
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.INSERT_USUARIO.getSql(), Statement.RETURN_GENERATED_KEYS)) {

            System.out.println("Conexão aberta!");

            stmt.setString(1, u.getNome());
            stmt.setInt(2, idDepartamento);
            stmt.setInt(3, idPermissao);

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
    public List<Usuario> listAll() {
        List<Usuario> usuarios = new LinkedList<>();
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.LISTALL_USUARIO.getSql())) {

            System.out.println("Conexão aberta!");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_Usuario");
                String nome = rs.getString("nome");
                Departamento departamento = new DepartamentoDAO().find(connection, rs.getInt("id_Departamento"));
                Permissao permissao = new PermissaoDAO().find(connection, rs.getInt("id_Permissao"));
                usuarios.add(new Usuario(id, nome, departamento, permissao));
            }

            return usuarios;
        } catch (SQLException ex) {
            System.out.println("Exceção de SQL.");
        }
        return null;
    }

    @Override
    public int update(Usuario u) {
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.UPDATE_USUARIO.getSql())) {

            stmt.setString(1, u.getNome());
            stmt.setInt(2, u.getDepartamento().getIdDepartamento());
            stmt.setInt(3, u.getPermissao().getIdPermissao());
            stmt.setInt(4, u.getIdUsuario());

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
                PreparedStatement stmt = connection.prepareStatement(SQLs.DELETE_USUARIO.getSql())) {

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
    public Usuario findById(int id) {
        Usuario u = null;
        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement stmt = connection.prepareStatement(SQLs.FINDBYID_USUARIO.getSql())) {

            stmt.setInt(1, id);

            System.out.println("Conexão aberta!");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                Departamento departamento = new DepartamentoDAO().find(connection, rs.getInt("id_Departamento"));
                Permissao permissao = new PermissaoDAO().find(connection, rs.getInt("id_Permissao"));
                u = new Usuario(id, nome, departamento, permissao);
            }
        } catch (SQLException ex) {
            System.out.println("Exceção SQL - findById");
        } catch (Exception ex) {
            System.out.println("Exceção no código!- findById");
        }
        return u;
    }

    public Usuario find(Connection connection, int idUsuario) {
        try {
            PreparedStatement stmt = connection.prepareStatement(SQLs.FINDBYID_USUARIO.getSql());

            stmt.setInt(1, idUsuario);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                int idDepartamento = rs.getInt("id_Departamento");
                int idPermissao = rs.getInt("id_Permissao");
                Departamento departamento = new DepartamentoDAO().find(connection, rs.getInt("id_Departamento"));
                Permissao permissao = new PermissaoDAO().find(connection, rs.getInt("id_Permissao"));
                return new Usuario(nome, departamento, permissao);
            }
        } catch (SQLException e) {
            System.out.println("Exceção find PeriodoDAO");
        }
        return null;
    }

}
