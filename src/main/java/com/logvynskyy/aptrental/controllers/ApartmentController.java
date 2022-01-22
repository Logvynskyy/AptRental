package com.logvynskyy.aptrental.controllers;

import com.logvynskyy.aptrental.beans.Apartment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RestController
public class ApartmentController {
    private List<Apartment> apartmentList = new ArrayList<>();
    private static int counter = 0;

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

//        apt.setOwner(user);
        apt.setKeywords(keywordSet);
        apt.setName(apartment.getName());
        apt.setDescription(apartment.getDescription());

        apartmentList.add(new Apartment(counter++, apartment.getName(), apartment.getDescription(),
                apartment.getKeywordsInString(), apartment.getKeywords()));

        return new ModelAndView("redirect:/main");
    }

    @GetMapping("/apartment/{id}")
    public ModelAndView getApartment(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("apartment");
        for (Apartment apartment : apartmentList) {
            if (apartment.getId() == id) {
                modelAndView.addObject("apt", apartment);
            }
        }
        return modelAndView;
    }

    @GetMapping("/apartment/edit/{id}")
    public ModelAndView editApartment(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("editApartment");
        for(int i = 0; i < apartmentList.size(); i++){
            if (apartmentList.get(i).getId() == id) {
                modelAndView = new ModelAndView("editApartment", "command", apartmentList.get(i));
                apartmentList.remove(i);
            }
        }
        return modelAndView;
    }

    @GetMapping("/apartment/delete/{id}")
    public ModelAndView deleteApartment(@PathVariable int id){
        for (int i = 0; i < apartmentList.size(); i++) {
            if (apartmentList.get(i).getId() == id) {
                apartmentList.remove(i);
            }
        }
        return new ModelAndView("redirect:/main");
    }
}
