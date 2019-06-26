package pojo;

public class Usuario {

    private int idUsuario;
    private String nome;
    private Departamento departamento;
    private Permissao permissao;

    public Usuario() {
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

}
