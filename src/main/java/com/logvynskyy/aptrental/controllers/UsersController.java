package com.logvynskyy.aptrental.controllers;

import com.logvynskyy.aptrental.beans.User;
import com.logvynskyy.aptrental.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UsersController {
    private final UserDAO userDAO;

    @Autowired
    public UsersController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/registration")
    public ModelAndView registration(){
        return new ModelAndView("registration", "user", new User());
    }

    @PostMapping("/addUser")
    public ModelAndView register(@ModelAttribute User user){
        userDAO.addUser(user);

        return new ModelAndView("redirect:/main");
    }
}
