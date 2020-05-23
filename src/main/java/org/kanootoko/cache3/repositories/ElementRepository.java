package org.kanootoko.cache3.repositories;

import org.kanootoko.cache3.entities.Element;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepository extends CrudRepository<Element, Integer> {
    public Element findByElementID(int elementID);
    @SuppressWarnings("unchecked")
    public Element save(Element element);
}