package com.example.sweterfull.controller;


import com.example.sweterfull.domen.*;
import com.example.sweterfull.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @Autowired
    MessageRepo messageRepo;

    @GetMapping("/")
    public String greeting(Model model){
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Model model){
        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);

        return "main";
    }

    @PostMapping("/main")
    public String addMessage(
                            @AuthenticationPrincipal User user,
                            @RequestParam String text,
                            @RequestParam String tag,
                             Model model){
        Message message  = new Message(text, tag, user);
        messageRepo.save(message);
        return "main";
    }

    @PostMapping("/filter")
    public String getMessagesByTag(
                        @RequestParam String filter,
                        Model model){
        Iterable<Message> messages;
        if(filter != null && !filter.isEmpty()){
            messages = messageRepo.findByTag(filter);
        }else {
            messages = messageRepo.findAll();
        }
        model.addAttribute("messages",messages);
        return "main";
    }



}
