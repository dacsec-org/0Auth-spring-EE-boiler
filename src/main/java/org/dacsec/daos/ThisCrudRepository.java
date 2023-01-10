package org.dacsec.daos;

import org.dacsec.domains.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ThisCrudRepository extends CrudRepository<Logger, Serializable> {
    @Override
    void deleteById(Serializable serializable);
}
