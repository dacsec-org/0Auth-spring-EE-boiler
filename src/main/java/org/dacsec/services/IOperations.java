package org.dacsec.services;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * {@link IOperations} defines a set of common operations that any service can implement.
 * @param <T> the type of the entity that the service manages
 */
public interface IOperations<T extends Serializable> {
    // find
    T findOne(final long id);
    List<T> findAll();
    //FIXME: related problems
    Page<T> findPaginated(int page, int size);
    // save
    T create(final T entity);
    T update(final T entity);
     // delete
    void delete(final T entity);
    void deleteById(final long entityId);
    
}
