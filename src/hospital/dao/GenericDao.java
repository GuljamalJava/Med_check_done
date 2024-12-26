package hospital.dao;

import java.util.Optional;

public interface GenericDao<T,L> {
    String add(L hospitalId, T t);

    void removeById(L id);

    String updateById(L id, T t);
}
