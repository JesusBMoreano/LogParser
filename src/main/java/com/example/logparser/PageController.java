package com.example.logparser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;


@Controller
public class PageController {
    @GetMapping("/")
    public String index(Model model){
        return "Page";
    }
}
