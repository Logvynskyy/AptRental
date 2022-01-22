package com.logvynskyy.aptrental.controllers;

import com.logvynskyy.aptrental.beans.Apartment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
//@RequestMapping("/apartment")
public class ApartmentOperationsController {

//    @GetMapping("/{id}") //TODO когда будет рабочее соединение с БД тогда сделаю этот контроллер отдельно
//    public ModelAndView getApartment(@PathVariable int id){
//        ModelAndView modelAndView = new ModelAndView("apartment");
//        for (Apartment apartment : apartmentList) {
//            if (apartment.getId() == id) {
//                modelAndView.addObject("apt", apartment);
//            }
//        }
//        return modelAndView;
//    }
}
