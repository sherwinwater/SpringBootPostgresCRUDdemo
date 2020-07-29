package com.sherwin.postgresdemo.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sherwin.postgresdemo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/email")
    public String sendEmail() {
        try {
            emailService.sendSimpleMessage();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return "index";
    }
}
