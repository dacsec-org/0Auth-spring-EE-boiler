package org.dacsec.services;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

public interface IOperations<T extends Serializable> {
    // find
    T findOne(final long id);
    List<T> findAll();
    Page<T> findPaginated(int page, int size);
    // save
    T create(final T entity);
    T update(final T entity);
     // delete
    void delete(final T entity);
    void deleteById(final long entityId);
    
}
