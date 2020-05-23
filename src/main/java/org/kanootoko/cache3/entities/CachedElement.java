package org.kanootoko.cache3.entities;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="CachedElements")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CachedElement {

    @Id
    @Column(name = "ElementID")
    protected int elementID;

    @Column(name = "String")
    protected String string;

    public CachedElement() {
        super();
    }
    
    public CachedElement(int elementID, String string) {
        this.elementID = elementID;
        this.string = string;
    }
    
    @Override
    public String toString() {
        return String.format("element #%d: %s", elementID, string);
    }
}