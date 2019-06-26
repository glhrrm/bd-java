package pojo;

public class Departamento {

    private int idDepartamento;
    private String nome;

    public Departamento() {
    }

    public Departamento(int idDepartamento, String nome) {
        this.idDepartamento = idDepartamento;
        this.nome = nome;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Departamento{" + "idDepartamento=" + idDepartamento + ", nome=" + nome + '}';
    }

}
