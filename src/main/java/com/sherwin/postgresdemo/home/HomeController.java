package com.sherwin.postgresdemo.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/layout")
    public String layoutPage() {
        return "layout";
    }


//    @GetMapping("/main")
//    public String mainPage() {
//        return "layout/main";
//    }
}