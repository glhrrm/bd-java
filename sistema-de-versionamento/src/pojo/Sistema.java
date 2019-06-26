package pojo;

import dao.SistemaDAO;
import java.time.LocalDate;
import java.util.List;

public class Sistema {

    private int idSistema;
    private boolean ativo;
    private LocalDate criacao;
    private Usuario usuario;

    public Sistema() {
    }

    public Sistema(int idSistema, boolean ativo, LocalDate criacao, Usuario usuario) {
        this.idSistema = idSistema;
        this.ativo = ativo;
        this.criacao = criacao;
        this.usuario = usuario;
    }

    public int getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(int idSistema) {
        this.idSistema = idSistema;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getCriacao() {
        return criacao;
    }

    public void setCriacao(LocalDate criacao) {
        this.criacao = criacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return usuario != null
                ? "Sistema{" + "idSistema=" + idSistema + ", ativo=" + ativo + ", criacao=" + criacao + ", usuario=" + usuario + '}'
                : "Sistema{" + "idSistema=" + idSistema + ", ativo=" + ativo + ", criacao=" + criacao + ", usuario não informado";
    }

    public int insert() {
        return new SistemaDAO().insert(this);
    }

    public List<Sistema> listAll() {
        return new SistemaDAO().listAll();
    }

    public int update(Sistema s) {
        return new SistemaDAO().update(s);
    }

    public int delete(int id) {
        return new SistemaDAO().delete(id);
    }

    public Sistema findById(int id) {
        return new SistemaDAO().findById(id);
    }


}
