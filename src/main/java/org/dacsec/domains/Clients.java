package org.dacsec.domains;

import jakarta.persistence.*;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

@NamedNativeQueries({@NamedNativeQuery(
  name = "callGetAllClients",
  query = "CALL GetAllClients()",
  resultClass = Clients.class),
  @NamedNativeQuery(
    name = "callGetClientsByName",
    query = "CALL GetClientsByName(:ClientsName)",
    resultClass = Clients.class)})
@Entity
public class Clients <E> implements Serializable, Collection<E> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @ManyToOne(targetEntity =
                 Logger.class,
      cascade = CascadeType.ALL,
      fetch = FetchType.EAGER)
    @JoinColumn(name = "BAR_ID")
    private Logger logger = new Logger() {
        @Override
        Logger getLogger() {
            this.logger = (Logger) LoggerFactory.getLogger(Logger.class);
            return this.logger;
        }
    };
    
    public Clients() { super(); }
    public Clients(final String name) { super(); this.name = name; }
    
    public Logger getBar() {
        return logger;
    }
    public void setBar(final Logger logger) {
        this.logger = logger;
    }
    
    public long getId() {
        return id;
    }
    public void setId(final long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    
    @Override
    public int size() { return 0; }
    
    @Override
    public boolean isEmpty() {
        return false;
    }
    
    @Override
    public boolean contains(Object o) {
        return false;
    }
    
    @Override
    public Iterator<E> iterator() { return null; }
    
    @Override
    public Object[] toArray() {
        return new Object[0];
    }
    
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }
    
    @Override
    public boolean add(E e) {
        return false;
    }
    
    @Override
    public boolean remove(Object o) {
        return false;
    }
    
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }
    
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }
    
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }
    
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
    
    @Override
    public void clear() {
    
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) { return true; }
        if (obj == null) { return false; }
        if (getClass() != obj.getClass()) { return false; }
        final Clients other = (Clients) obj;
        if (name == null) {
            return other.name == null;
        } else return name.equals(other.name);
    }
    
    @Override
    public String toString() {
        return "Clients [name=" + name + "]";
    }
}
