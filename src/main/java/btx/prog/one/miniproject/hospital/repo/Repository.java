package btx.prog.one.miniproject.hospital.repo;

import java.util.List;
import java.util.Optional;

public interface Repository<T extends BaseEntity>{
    Optional<T> findById(long id);
    List<T> findAll();
    Object add(T object);
    Object update(T object);

}
