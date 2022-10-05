package com.logvynskyy.aptrental.controllers;

import com.logvynskyy.aptrental.entities.Apartment;
import com.logvynskyy.aptrental.dao.ApartmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/apartment")
public class ApartmentOperationsController {
    private final ApartmentDAO apartmentDAO;

    @Autowired
    public ApartmentOperationsController(ApartmentDAO apartmentDAO) {
        this.apartmentDAO = apartmentDAO;
    }

    @GetMapping("/{id}")
    public ModelAndView getApartment(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("apartment");
        modelAndView.addObject("apt", apartmentDAO.getApartment(id));

        return modelAndView;
    }

    @GetMapping("edit/{id}")
//    @PreAuthorize("authentication.principal.username.equals(#apartmentDAO.apartmentList.get({id}).owner)")
    public ModelAndView editApartment(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("editApartment", "apartment", apartmentDAO.getApartment(id));
        modelAndView.addObject("apt", apartmentDAO.getApartment(id));

        return modelAndView;
    }

    @PatchMapping("/{id}")
    public ModelAndView updateApartment(@ModelAttribute Apartment apartment, @PathVariable int id){
        apartmentDAO.editApartment(id, apartment);

        return new ModelAndView("redirect:/main");
    }

    @DeleteMapping("/{id}")
    public ModelAndView deleteApartment(@PathVariable int id){
        apartmentDAO.deleteApartment(id);

        return new ModelAndView("redirect:/main");
    }
}
