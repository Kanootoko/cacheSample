package org.kanootoko.cache3.services.impl;

import org.kanootoko.cache3.entities.CachedElement;
import org.kanootoko.cache3.repositories.CachedElementRepository;
import org.kanootoko.cache3.services.CachedElementService;
// import org.kanootoko.cache3.utils.RepositoriesFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CachedElementServiceDefault implements CachedElementService {
    @Autowired
    CachedElementRepository CachedelementRepository; //= RepositoriesFactory.CachedgetElementRepository();

    @Override
    public CachedElement getCachedElementByID(int id) {
        return CachedelementRepository.findByElementID(id);
    }

    @Override
    public CachedElement addCachedElement(CachedElement cachedElement) {
        return CachedelementRepository.save(cachedElement);
    }
    
}