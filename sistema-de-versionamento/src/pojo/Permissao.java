package pojo;

import dao.PermissaoDAO;
import java.util.List;

public class Permissao {

    private int idPermissao;
    private String nome;

    public Permissao() {
    }

    public Permissao(String nome) {
        this(-1, nome);
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

    public int insert() {
        return new PermissaoDAO().insert(this);
    }

    public List<Permissao> listAll() {
        return new PermissaoDAO().listAll();
    }

    public int update(Permissao p) {
        return new PermissaoDAO().update(p);
    }

    public int delete(int id) {
        return new PermissaoDAO().delete(id);
    }

    public Permissao findById(int id) {
        return new PermissaoDAO().findById(id);
    }

}
