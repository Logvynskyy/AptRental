package com.logvynskyy.aptrental.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @RequestMapping("/a")
    public void testMethod(){
        System.out.println("dadad");
    }
}
