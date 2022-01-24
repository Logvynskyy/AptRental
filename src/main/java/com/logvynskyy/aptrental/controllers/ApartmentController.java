package com.logvynskyy.aptrental.controllers;

import com.logvynskyy.aptrental.beans.Apartment;
import com.logvynskyy.aptrental.dao.ApartmentDAO;
import com.logvynskyy.aptrental.dao.ImageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashSet;

@RestController
public class ApartmentController {
    private final ApartmentDAO apartmentDAO;
    private final ImageDAO imageDAO;

    @Autowired
    public ApartmentController(ApartmentDAO apartmentDAO, ImageDAO imageDAO) {
        this.apartmentDAO = apartmentDAO;
        this.imageDAO = imageDAO;
    }

    @GetMapping("/main")
    public ModelAndView main(){
        return new ModelAndView("main", "list", apartmentDAO.getAllApartments());
    }

    @GetMapping("/addApartment")
    public ModelAndView addApartment(){
        return new ModelAndView("addApartment", "apartment", new Apartment());
    }

    @PostMapping("/saveApartment")
    public ModelAndView saveApartment(@ModelAttribute Apartment apartment){
//        User user = (User) request.getSession().getAttribute("user");
        String[] keywordsArr = apartment.getKeywordsInString().split(", ");
        HashSet<String> keywordSet = new HashSet<>(Arrays.asList(keywordsArr));

//        apt.setOwner(user);
        apartment.setKeywords(keywordSet);
        apartmentDAO.addApartment(apartment);
        imageDAO.uploadImage(apartment.getFiles());

        return new ModelAndView("redirect:/main");
    }
}
