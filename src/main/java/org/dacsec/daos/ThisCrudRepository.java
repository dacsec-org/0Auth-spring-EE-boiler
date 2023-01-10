package org.dacsec.daos;

import org.dacsec.domains.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * {@link CrudRepository} for {@link Logger} entities.
 */
@Repository
public interface ThisCrudRepository extends CrudRepository<Logger, Serializable> {
    @Override
    void deleteAll(Iterable<? extends Logger> entities);
    
    @Override
    void deleteAll();
    
    @Override
    <S extends Logger> Iterable<S> saveAll(Iterable<S> entities);
    
    @Override
    Iterable<Logger> findAllById(Iterable<Serializable> serializable);
    
    @Override
    long count();
    
    @Override
    boolean existsById(Serializable serializable);
}
