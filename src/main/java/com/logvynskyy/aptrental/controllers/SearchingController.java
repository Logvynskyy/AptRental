package com.logvynskyy.aptrental.controllers;

import com.logvynskyy.aptrental.services.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SearchingController {
    private final ApartmentService apartmentService;

    @Autowired
    public SearchingController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping("/search")
    public ModelAndView querySubmit(@RequestParam(value="query", defaultValue = "") String query) {
        return new ModelAndView("aptList", "list", apartmentService.getApartmentsByFeatures(query));
    }
}
