package dao;

import java.util.List;

public interface DAO<T> {

    public int insert();

    public List<T> listAll();

    public int update(T t);

    public int delete(int id);

    public T findById(int id);

}
