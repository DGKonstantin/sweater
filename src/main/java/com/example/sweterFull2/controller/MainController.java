package com.example.sweterFull2.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/main")
    public String greeting(
            @RequestParam (required = false, defaultValue = "Anonymous") String name,
            Model model){
        model.addAttribute("name", name);
        return "main";
    }

    @GetMapping()
    public String main(){
        return "redirect:/main";
    }

}
