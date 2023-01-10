package org.dacsec.repositories;

import org.springframework.security.core.userdetails.User;

import java.util.*;
import java.util.function.Predicate;

/**
 * {@link UserRepositoryCustom} custom methods.
 */
public interface UserRepositoryCustom {
    List<User> findUserByEmails(Set<String> emails);
    
    List<User> findAllUsersByPredicates(Collection<Predicate<User>> predicates);
}
