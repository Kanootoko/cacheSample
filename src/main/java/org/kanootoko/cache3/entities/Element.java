package org.kanootoko.cache3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Element")
public class Element {
    @Id
    @Column(name = "ElementID")
    protected int elementID;

    @Column(name = "String")
    protected String string;

    public Element() {
    }

    public Element(int elementID, String string) {
        this.elementID = elementID;
        this.string = string;
    }

    @Override
    public String toString() {
        return String.format("element #%d: %s", elementID, string);
    }
}