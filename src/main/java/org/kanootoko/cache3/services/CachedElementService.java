package org.kanootoko.cache3.services;

import org.kanootoko.cache3.entities.CachedElement;
import org.springframework.stereotype.Service;

@Service
public interface CachedElementService {
    public CachedElement getCachedElementByID(int id);
    public CachedElement addCachedElement(CachedElement cachedElement);
}