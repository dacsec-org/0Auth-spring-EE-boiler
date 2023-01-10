package org.dacsec.domains;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * {@link UserPage} is a domain class that represents a user page.
 */
@Entity
@Table(name = "users")
public class UserPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate creationDate;
    private LocalDate lastLoginDate;
    private boolean active;
    private int age;
    @Column(unique = true, nullable = false)
    private String email;
    private Integer status;
    @OneToMany
    List<Possession> possessionList;
    
    public UserPage() {
        super();
    }
    
    public UserPage(String name, LocalDate creationDate, String email, Integer status) {
        this.name = name;
        this.creationDate = creationDate;
        this.email = email;
        this.status = status;
        this.active = true;
    }
    
    public int getId() { return id; }
    public void setId(final int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(final String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(final String email) { this.email = email; }
    
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    
    public int getAge() { return age; }
    public void setAge(final int age) { this.age = age; }
    
    public LocalDate getCreationDate() { return creationDate; }
    
    public List<Possession> getPossessionList() { return possessionList; }
    public void setPossessionList(List<Possession> possessionList) {
        this.possessionList = possessionList;
    }
    
    @Override
    public String toString() {
        return "UserPage [name=" +
                           name +
                           ", id=" +
                           id +
                           "]";
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        UserPage userPage = (UserPage) o;
        return id == userPage.id &&
                 age == userPage.age &&
                 Objects.equals(name, userPage.name) &&
                 Objects.equals(creationDate, userPage.creationDate) &&
                 Objects.equals(email, userPage.email) &&
                 Objects.equals(status, userPage.status);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, creationDate, age, email, status);
    }
    
    public LocalDate getLastLoginDate() { return lastLoginDate; }
    public void setLastLoginDate(LocalDate lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
    
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
