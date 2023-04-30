package com.example.sweeterfull.controller;

import com.example.sweeterfull.domen.Message;
import com.example.sweeterfull.domen.User;
import com.example.sweeterfull.repos.MessageRepo;
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
    public String greeting(Model model) {
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
                    Model model
    ){
        Message message = new Message(text, tag);
        messageRepo.save(message);


        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);

        return "main";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String loginPOST(User user){
        return "main";
    }
}