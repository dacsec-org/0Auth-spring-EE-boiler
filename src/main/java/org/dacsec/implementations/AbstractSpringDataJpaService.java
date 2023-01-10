package org.dacsec.implementations;

import org.dacsec.services.IOperations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * {@link AbstractSpringDataJpaService} provides a base implementation of
 * {@link IOperations} to reduce the amount of code that must be written.
 * @param <T> the type of entity
 */
@Transactional(value = "transactionManager")
public abstract class AbstractSpringDataJpaService<T extends Serializable> implements IOperations<T> {
    
    @Override
    public T findOne(final long id) {
        return getDao().findById(id).orElse(null);
    }
    
    @Override
    public List<T> findAll() {
        return List.of((T) getDao().findAll());
    }
    //FIXME: unchecked cast
    
    @Override
    public T create(final T entity) {
        return getDao().save(entity);
    }
    
    @Override
    public T update(final T entity) {
        return getDao().save(entity);
    }
    
    @Override
    public void delete(final T entity) {
        getDao().delete(entity);
    }
    
    @Override
    public void deleteById(final long entityId) {
        getDao().deleteById(entityId);
    }
    
    protected abstract CrudRepository<T, Serializable> getDao();
}
