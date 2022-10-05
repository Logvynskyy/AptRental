package com.logvynskyy.aptrental.controllers;

import com.logvynskyy.aptrental.services.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/search")
public class SearchingController {
    private final ApartmentService apartmentService;

    @Autowired
    public SearchingController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping()
    public ModelAndView search(){
        return new ModelAndView("search");
    }

    @GetMapping("/request")
    public ModelAndView querySubmit(@RequestParam(value="query", defaultValue = "") String query) {
        if(query.isEmpty() || query.isBlank())
            return new ModelAndView("search", "error", "Please enter desired parameters!");
        if(apartmentService.getApartmentsByFeatures(query).size() == 0)
            return new ModelAndView("search", "error", "We didn't find anything" +
                    "with given parameters.<br> Please try something different!");
        return new ModelAndView("aptList", "list", apartmentService.getApartmentsByFeatures(query));
    }
}
