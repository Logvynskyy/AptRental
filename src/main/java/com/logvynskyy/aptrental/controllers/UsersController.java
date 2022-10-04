package com.logvynskyy.aptrental.controllers;

import com.logvynskyy.aptrental.entities.User;
import com.logvynskyy.aptrental.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public ModelAndView registration(){
        return new ModelAndView("registration", "user", new User());
    }

    @PostMapping("/addUser")
    public ModelAndView register(@ModelAttribute User user){
        ModelAndView modelAndView;

        if (!userService.saveUser(user)){
            modelAndView = new ModelAndView("registration", "user", new User());
            modelAndView.addObject("usernameError", "User with this name is already present");
            return modelAndView;
        }

        return new ModelAndView("redirect:/main");
    }
}
