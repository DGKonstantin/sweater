package com.example.sweeterfull.controller;

import com.example.sweeterfull.domen.Role;
import com.example.sweeterfull.domen.User;
import com.example.sweeterfull.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepo userRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model){
        User userFromDB = userRepo.findByUsername(user.getUsername());

        if(userFromDB != null){
            model.addAttribute("message", "User exist!");
            return "registration";
        }

        final String encodedPassword = passwordEncoder.encode(user.getPassword());

//        user.setPassword(encodedPassword);
        user.setEnabled(true);
        user.setAuthority(Collections.singleton(Role.ROLE_USER));

        userRepo.save(user);

        return "redirect:/login";
    }
}
