package dao;

import java.util.List;

public interface IDAO<T> {

   public void create(T obj);

   public void read();

   public void update(T obj);

   public void delete(T obj);

   public List<T> getAll();
}
