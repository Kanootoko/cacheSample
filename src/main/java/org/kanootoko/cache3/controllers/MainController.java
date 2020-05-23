package org.kanootoko.cache3.controllers;

import java.util.ArrayList;
import java.util.List;

import org.kanootoko.cache3.entities.CachedElement;
import org.kanootoko.cache3.entities.Element;
import org.kanootoko.cache3.services.CachedElementService;
import org.kanootoko.cache3.services.ElementService;
// import org.kanootoko.cache3.utils.ServicesFactory;
import org.kanootoko.cache3.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ComponentScan
public class MainController {

    @Autowired
    private ElementService elementService;

    @Autowired
    private CachedElementService cachedElementService;

    @GetMapping("/")
    public String getMainPage() {
        return "mainPage.html";
    }

    @PostMapping("/insert")
    public String insertData(Model model, @RequestParam Integer rangeStart, @RequestParam Integer rangeFinish,
            @RequestParam(required = false, defaultValue = "0") Boolean cached) {

        // ElementService elementService = ServicesFactory.getElementService();
        if (rangeFinish - rangeStart > 3000) {
            rangeStart = 0;
            rangeFinish = 3000;
        }
        List<Element> elements = null;
        List<CachedElement> cachedElements = null;
        if (cached) {
            cachedElements = new ArrayList<>();
            for (int id = rangeStart; id <= rangeFinish; ++id) {
                // cachedElements.add(new CachedElement(id, Utils.calcMD5(String.valueOf(id * 14 / 1.52))));
                cachedElements.add(new CachedElement(id, Utils.generateString(60)));
            }
        } else {
            elements = new ArrayList<>();
            for (int id = rangeStart; id <= rangeFinish; ++id) {
                // elements.add(new Element(id, Utils.calcMD5(String.valueOf(id * 14 / 1.52))));
                elements.add(new Element(id, Utils.generateString(60)));
            }
        }
        long startTime = System.currentTimeMillis();
        if (cached) {
            for (CachedElement ce : cachedElements) {
                cachedElementService.addCachedElement(ce);
            }
        } else {
            for (Element e : elements) {
                elementService.addElement(e);
            }
        }
        model.addAttribute("time", System.currentTimeMillis() - startTime);
        model.addAttribute("requestType",
                (cached ? "cacheble " : "") + "insert for " + (rangeFinish - rangeStart + 1) + " objects");
        return "timeConsumed.html";
    }

    @GetMapping("/select")
    public String selectData(Model model, @RequestParam Integer rangeStart, @RequestParam Integer rangeFinish,
            @RequestParam(required = false, defaultValue = "0") Boolean cached) {
        if (rangeFinish - rangeStart > 3000) {
            rangeStart = 0;
            rangeFinish = 3000;
        }
        long startTime = System.currentTimeMillis();
        if (cached) {
            for (int id = rangeStart; id <= rangeFinish; ++id) {
                cachedElementService.getCachedElementByID(id);
            }
        } else {
            for (int id = rangeStart; id <= rangeFinish; ++id) {
                elementService.getElementByID(id);
            }
        }
        model.addAttribute("time", System.currentTimeMillis() - startTime);
        model.addAttribute("requestType",
                (cached ? "cacheble " : "") + "select for " + (rangeFinish - rangeStart + 1) + " objects");
        return "timeConsumed.html";
    }
}