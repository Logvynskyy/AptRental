package com.logvynskyy.aptrental.controllers;

import com.logvynskyy.aptrental.beans.Apartment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RestController
public class ApartmentController {
    private List<Apartment> apartmentList = new ArrayList<>();

    @GetMapping("/main")
    public ModelAndView main(){
        return new ModelAndView("main", "list", apartmentList);
    }

    @GetMapping("/addApartment")
    public ModelAndView addApartment(){
        return new ModelAndView("addApartment", "command", new Apartment());
    }

    @PostMapping("/saveApartment")
    public ModelAndView saveApartment(@ModelAttribute Apartment apartment){
        Apartment apt = new Apartment();
//        User user = (User) request.getSession().getAttribute("user");
        String[] keywordsArr = apartment.getKeywordsInString().split(", ");
        HashSet<String> keywordSet = new HashSet<>(Arrays.asList(keywordsArr));

//        infoBlank.setOwner(user);
        apt.setKeywords(keywordSet);
        apt.setName(apartment.getName());
        apt.setDescription(apartment.getDescription());

        apartmentList.add(new Apartment(apartment.getName(), apartment.getDescription(),
                apartment.getKeywordsInString(), apartment.getKeywords()));

        return new ModelAndView("redirect:/main");
    }
}
