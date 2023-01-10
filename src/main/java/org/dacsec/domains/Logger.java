package org.dacsec.domains;

import jakarta.persistence.*;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.OrderBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@NamedQuery(name = "Logger.findAll", query = "SELECT b FROM Logger b")
@EntityListeners(AuditingEntityListener.class)
public abstract class Logger implements Serializable {
    
    Logger logger = Logger.this; //abstract Logger getLogger();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "bar", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(clause =     "NAME DESC")
    
    // @NotAudited
    private Set<Object> clientsSet = Set.copyOf(new Clients<>());
    @Column(name = "operation")
    private String operation;
    @Column(name = "timestamp")
    private long timestamp;
    @Column(name = "created_date", updatable = false, nullable = false)
    @CreatedDate
    private long createdDate;
    @Column(name = "modified_date")
    @LastModifiedDate
    private long modifiedDate;
    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;
    @Column(name = "modified_by")
    @LastModifiedBy
    private String modifiedBy;
    
    public Logger() {
        super();
    }
    
    public Logger(final String name) { super(); this.name = name; }
    
    public Set<Object> getFooSet() {
        return clientsSet;
    }
    
    // API
    public void setFooSet(final Set<Object> clientsSet) {
        this.clientsSet = clientsSet;
    }
    
    public int getId() {
        return id;
    }
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }
    
    public OPERATION getOperation() {
        return OPERATION.parse(operation);
    }
    public void setOperation(final String operation) {
        this.operation = operation;
    }
    
    public void setOperation(final OPERATION operation) {
        this.operation = operation.getValue();
    }
    
    public long getTimestamp() { return timestamp; }
    public void setTimestamp(final long timestamp) {
        this.timestamp = timestamp;
    }
    
    public long getCreatedDate() { return createdDate; }
    public void setCreatedDate(final long createdDate) {
        this.createdDate = createdDate;
    }
    
    public long getModifiedDate() { return modifiedDate; }
    public void setModifiedDate(final long modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }
    
    public String getModifiedBy() { return modifiedBy; }
    public void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) { return true; }
        if (obj == null) { return false; }
        if (getClass() != obj.getClass()) { return false; }
        final Logger other = (Logger) obj;
        if (name == null) {
            return other.name == null;
        } else return name.equals(other.name);
    }
    
    @Override
    public String toString() {
        return "Logger [name=" + name + "]";
    }
    
    @PrePersist
    public void onPrePersist() {
        logger.info("@PrePersist");
        audit(OPERATION.INSERT);
    }
    
    private void info(String s) { this.operation = s; }
    
    @PreUpdate
    public void onPreUpdate() {
        logger.info("@PreUpdate");
        audit(OPERATION.UPDATE);
    }
    
    @PreRemove
    public void onPreRemove() {
        logger.info("@PreRemove");
        audit(OPERATION.DELETE);
    }
    
    private void audit(final OPERATION operation) {
        setOperation(operation);
        setTimestamp((new Date()).getTime());
    }
    
    abstract Logger getLogger();
    
    public enum OPERATION {
        INSERT, UPDATE, DELETE;
        private final String value;
        OPERATION() { value = toString(); }
    
        public static OPERATION parse(final String value) {
            OPERATION operation = null;
            for (final OPERATION op : OPERATION.values()) {
                if (op.getValue().equals(value)) {
                    operation = op;
                    break;
                }
            }
            return operation;
        }
    
        public String getValue() { return value; }
    }
}
