package pojo;

public class Versao {

    private int idVersao;
    private String versao;
    private String novidades;
    private Sistema sistema;

    public Versao() {
    }

    public Versao(int idVersao, String versao, String novidades, Sistema sistema) {
        this.idVersao = idVersao;
        this.versao = versao;
        this.novidades = novidades;
        this.sistema = sistema;
    }

    public int getIdVersao() {
        return idVersao;
    }

    public void setIdVersao(int idVersao) {
        this.idVersao = idVersao;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getNovidades() {
        return novidades;
    }

    public void setNovidades(String novidades) {
        this.novidades = novidades;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    @Override
    public String toString() {
        return sistema != null
                ? "Versao{" + "idVersao=" + idVersao + ", versao=" + versao + ", novidades=" + novidades + ", sistema=" + sistema + '}'
                : "Versao{" + "idVersao=" + idVersao + ", versao=" + versao + ", novidades=" + novidades + ", sistema não informado";
    }

}
