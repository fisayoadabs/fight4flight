package io.group02.fight4flight.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.group02.fight4flight.domain.Registered;
import io.group02.fight4flight.repository.RegisteredRepository;
import io.group02.fight4flight.service.RegisteredService;

import java.util.List;

@RestController
@RequestMapping("/registered")
@CrossOrigin
public class RegisteredController {
    @Autowired
    private RegisteredService userService;
    @Autowired
    private RegisteredRepository userRepo;

    @PostMapping("/register")
    public String register(@RequestBody Registered user) {
        userService.saveRegistered(user);
        return "You are a memeber";
    }

    @GetMapping("/getAll")
    public List<Registered> list() {
        return userService.getAllRegistereds();
        // return userRepo.findByUsername("fundraiser");
    }

    // @GetMapping("/checkUsername")
    // public List<Registered> list() {
    // return userRepo.findByUsername("dfcool");
    // }
}
