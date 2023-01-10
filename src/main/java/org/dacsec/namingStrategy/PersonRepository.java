package org.dacsec.namingStrategy;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * {@link PersonRepository} is a repository for {@link Person} entity.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {}
