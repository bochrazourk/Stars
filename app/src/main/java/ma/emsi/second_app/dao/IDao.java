package ma.emsi.second_app.dao;

import java.util.List;

public interface IDao <T> {
    public boolean create(T o) ;
    public boolean update(T o) ;
    public boolean delete(T o) ;
    public List<T> findAll() ;
    public T findById(int id) ;
}
