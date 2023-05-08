package com.example.sweterfull.controller;

import com.example.sweterfull.domen.Role;
import com.example.sweterfull.domen.User;
import com.example.sweterfull.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userRepo.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    public String editListForm(@PathVariable User user,
                               Model model){
        model.addAttribute("roles", Role.values());
        model.addAttribute("user", user);
        return "userEdit";
    }

    @PostMapping
    public String userSave(@RequestParam(name = "userId") User user,
                           @RequestParam Map<String, String> form,
                           @RequestParam String username){
        user.setUsername(username);

        user.getRoles().clear();

        Set<String> roles = Arrays.stream(Role.values())
                        .map(Role::name)
                                .collect(Collectors.toSet());
        for (String s : form.keySet()) {
            if(roles.contains(s)){
                user.getRoles().add(Role.valueOf(s));
            }
        }

        userRepo.save(user);
        return "redirect:/user";
    }
}
