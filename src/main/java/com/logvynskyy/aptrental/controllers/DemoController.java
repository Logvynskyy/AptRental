package com.logvynskyy.aptrental.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DemoController {
    @GetMapping("/a")
    public void testMethod(){
        System.out.println("dadad");
    }

    @GetMapping("/view")
    public ModelAndView getView(){
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("obj", "Object injection");
        return modelAndView;
    }
}
