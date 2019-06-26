package pojo;

public class Permissao {

    private int idPermissao;
    private String nome;

    public Permissao() {
    }

    public Permissao(int idPermissao, String nome) {
        this.idPermissao = idPermissao;
        this.nome = nome;
    }

    public int getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(int idPermissao) {
        this.idPermissao = idPermissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Permissao{" + "idPermissao=" + idPermissao + ", nome=" + nome + '}';
    }

}
