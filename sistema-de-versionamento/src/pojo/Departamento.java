package pojo;

import dao.DepartamentoDAO;
import java.util.List;

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
    
    public int insert() {
        return new DepartamentoDAO().insert(this);
    }

    public List<Departamento> listAll() {
        return new DepartamentoDAO().listAll();
    }

    public int update(Departamento d) {
        return new DepartamentoDAO().update(d);
    }

    public int delete(int id) {
        return new DepartamentoDAO().delete(id);
    }

    public Departamento findById(int id) {
        return new DepartamentoDAO().findById(id);
    }

}
