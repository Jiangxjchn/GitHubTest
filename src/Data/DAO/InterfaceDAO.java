package Data.DAO;

import java.util.List;

public interface InterfaceDAO<T> {
    boolean update(T o);
    boolean delete(T o);
    boolean save(T o);
}
