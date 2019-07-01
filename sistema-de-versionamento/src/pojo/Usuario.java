package pojo;

import dao.UsuarioDAO;
import java.util.List;

public class Usuario {

    private int idUsuario;
    private String nome;
    private Departamento departamento;
    private Permissao permissao;

    public Usuario() {
    }

    public Usuario(String nome, Departamento departamento, Permissao permissao) {
        this(-1, nome, departamento, permissao);
    }

    public Usuario(int idUsuario, String nome, Departamento departamento, Permissao permissao) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.departamento = departamento;
        this.permissao = permissao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    @Override
    public String toString() {
        return departamento != null && permissao != null
                ? "Usuario{" + "idUsuario=" + idUsuario + ", nome=" + nome + ", departamento=" + departamento + ", permissao=" + permissao + '}'
                : "Usuario{" + "idUsuario=" + idUsuario + ", nome=" + nome + ", departamento não informado, permissao não informada";
    }

    public int insert() {
        return new UsuarioDAO().insert(this);
    }

    public List<Usuario> listAll() {
        return new UsuarioDAO().listAll();
    }

    public int update(Usuario u) {
        return new UsuarioDAO().update(u);
    }

    public int delete(int id) {
        return new UsuarioDAO().delete(id);
    }

    public Usuario findById(int id) {
        return new UsuarioDAO().findById(id);
    }

}
