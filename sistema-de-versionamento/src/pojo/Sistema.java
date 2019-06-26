package pojo;

import java.time.LocalDate;

public class Sistema {

    private int idSistema;
    private boolean estado;
    private LocalDate criacao;
    private Usuario usuario;

    public Sistema() {
    }

    public Sistema(int idSistema, boolean estado, LocalDate criacao, Usuario usuario) {
        this.idSistema = idSistema;
        this.estado = estado;
        this.criacao = criacao;
        this.usuario = usuario;
    }

    public int getIdSistema() {
        return idSistema;
    }

    public void setIdSistema(int idSistema) {
        this.idSistema = idSistema;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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
                ? "Sistema{" + "idSistema=" + idSistema + ", estado=" + estado + ", criacao=" + criacao + ", usuario=" + usuario + '}'
                : "Sistema{" + "idSistema=" + idSistema + ", estado=" + estado + ", criacao=" + criacao + ", usuario não informado";
    }

}
