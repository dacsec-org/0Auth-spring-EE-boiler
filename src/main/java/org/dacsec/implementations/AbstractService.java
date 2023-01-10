package org.dacsec.implementations;

import org.assertj.core.util.Lists;
import org.dacsec.services.IOperations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * {@link AbstractService} provides a base implementation of {@link IOperations}
 * to reduce the amount of code that must be written.
 * @param <T> a generic type variable
 */
@Transactional
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {
    // read - one
    @Override
    @Transactional(readOnly = true)
    public T findOne(final long id) {
        return getDao().findById(id).orElse(null);
        //FIXME: findById
    }
    
    // read - all
    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }
    
    @Override
    public Page<T> findPaginated(final int page, final int size) {
        return getDao().findAll(PageRequest.of(page, size));
    }
    
    // write
    @Override
    public T create(final T entity) {
        return getDao().save(entity);
        //FIXME: save
    }
    
    @Override
    public T update(final T entity) {
        return getDao().save(entity);
    }
    
    @Override
    public void delete(final T entity) {
        getDao().delete(entity);
        //FIXME: delete
    }
    
    @Override
    public void deleteById(final long entityId) {
        getDao().deleteById(entityId);
        //FIXME: deleteById
    }
    
    protected abstract PagingAndSortingRepository<T, Long> getDao();
    
}
