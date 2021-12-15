package btx.prog.one.miniproject.hospital.repo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Repository<T extends BaseEntity>{
    T findById(long id);
    Map<Long,T> findAll();
    Object add(T object);
    void update(T object);
    void drop(T object);
    int size();
    void clear();

}
