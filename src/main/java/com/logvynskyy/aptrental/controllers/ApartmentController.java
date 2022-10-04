package com.logvynskyy.aptrental.controllers;

import com.logvynskyy.aptrental.entities.Apartment;
import com.logvynskyy.aptrental.dao.ApartmentDAO;
import com.logvynskyy.aptrental.dao.ImageDAO;
import com.logvynskyy.aptrental.services.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashSet;

@RestController
public class ApartmentController {
    private final ApartmentService apartmentService;
    private final ApartmentDAO apartmentDAO;
    private final ImageDAO imageDAO;

    @Autowired
    public ApartmentController(ApartmentService apartmentService, ApartmentDAO apartmentDAO, ImageDAO imageDAO) {
        this.apartmentService = apartmentService;
        this.apartmentDAO = apartmentDAO;
        this.imageDAO = imageDAO;
    }

    @GetMapping("/main")
    public ModelAndView main(){
        return new ModelAndView("main", "list", apartmentService.getAllApartments());
    }

    @GetMapping("/addApartment")
    public ModelAndView addApartment(){
        return new ModelAndView("addApartment", "apartment", new Apartment());
    }

    @PostMapping("/saveApartment")
    public ModelAndView saveApartment(@ModelAttribute Apartment apartment){
//        User user = (User) request.getSession().getAttribute("user");
        String[] keywordsArr = apartment.getKeywordsInString().split("[,?\\s*]");
        HashSet<String> keywordSet = new HashSet<>(Arrays.asList(keywordsArr));

//        apt.setOwner(user);
        apartment.setKeywords(keywordSet);
        apartmentDAO.addApartment(apartment);
        imageDAO.uploadImage(apartment.getFiles());

        return new ModelAndView("redirect:/main");
    }
}
