package org.kanootoko.cache3.services.impl;

import org.kanootoko.cache3.entities.Element;
import org.kanootoko.cache3.repositories.ElementRepository;
import org.kanootoko.cache3.services.ElementService;
// import org.kanootoko.cache3.utils.RepositoriesFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElementServiceDefault implements ElementService {
    @Autowired
    ElementRepository elementRepository; //= RepositoriesFactory.getElementRepository();

    @Override
    public Element getElementByID(int id) {
        return elementRepository.findByElementID(id);
    }

    @Override
    public Element addElement(Element element) {
        return elementRepository.save(element);
    }
    
}