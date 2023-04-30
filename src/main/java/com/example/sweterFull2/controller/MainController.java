package com.example.sweterFull2.controller;

import com.example.sweterFull2.domain.Message;
import com.example.sweterFull2.repos.MessageRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    MessageRepo messageRepo;

    @GetMapping("/main")
    public String greeting(
            @RequestParam (required = false, defaultValue = "Anonymous") String name,
            Model model){
        model.addAttribute("name", name);
        return "main";
    }

    @GetMapping()
    public String main(Model model){
        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);

        return "main";
    }

    @PostMapping()
    public String addMessage(@RequestParam String text,
                            @RequestParam String tag,
                            Model model){
        Message message  = new Message(text, tag);
        messageRepo.save(message);
        return "main";
    }

    @PostMapping("filter")
    public String getFMessagesByTag(
            @RequestParam String filter,
            Model model
    ){
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
