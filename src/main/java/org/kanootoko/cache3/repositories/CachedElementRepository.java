package org.kanootoko.cache3.repositories;

import org.kanootoko.cache3.entities.CachedElement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CachedElementRepository extends CrudRepository<CachedElement, Integer> {
    public CachedElement findByElementID(int elementID);
    @SuppressWarnings("unchecked")
    public CachedElement save(CachedElement element);
}