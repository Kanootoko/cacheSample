package org.kanootoko.cache3.services;

import org.kanootoko.cache3.entities.Element;
import org.springframework.stereotype.Service;

@Service
public interface ElementService {
    public Element getElementByID(int id);
    public Element addElement(Element element);
}