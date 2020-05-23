package org.kanootoko.cache3.utils;

import org.kanootoko.cache3.services.ElementService;
import org.kanootoko.cache3.services.impl.ElementServiceDefault;

public class ServicesFactory {
    public static ElementService getElementService() {
        return new ElementServiceDefault();
    }
}