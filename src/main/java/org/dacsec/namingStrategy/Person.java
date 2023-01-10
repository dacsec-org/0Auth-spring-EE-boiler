package org.dacsec.namingStrategy;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * {@link Person} is a simple entity class.
 */
@Entity
public class Person {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    public Person() {}
    
    public Person(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Long id() { return id; }
    
    public String firstName() { return firstName; }
    
    public String lastName() { return lastName; }
}
