package ru.gb.socialnet.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T,ID>{
    List<T> findAll();
    Optional<T> findById(ID id);
    <S extends T> S	save(S entity);
    void delete(T entity);
}
