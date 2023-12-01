package io.group02.fight4flight.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.group02.fight4flight.model.Registered;
import io.group02.fight4flight.model.Unregistered;
import io.group02.fight4flight.service.RegisteredService;
import io.group02.fight4flight.service.UnregisteredService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private RegisteredService registeredService;
    @Autowired
    private UnregisteredService unregisteredService;


    // Endpoint to add an unregistered user
    @PostMapping("/addUnregistered")
    public String addUnregistered(@RequestBody Unregistered customer) {
        unregisteredService.saveUnregistered(customer);
        return "Unregistered user created";
    }

    // Endpoint to get all unregistered users
    @GetMapping("/getAllUnregistered")
    public List<Unregistered> listAllUnregistered() {
        return unregisteredService.getAllUnregistereds();
    }

    @PostMapping("/register")
    public String register(@RequestBody Registered user) {
        // Create an Unregistered user with only common fields
        Unregistered unregisteredUser = new Unregistered(user.getEmail(), user.getFname(), user.getLname());
        unregisteredService.saveUnregistered(unregisteredUser);

        // Save the Registered user
        registeredService.saveRegistered(user);
        return "User registered successfully and added to both Unregistered and Registered tables.";
    }

    // Endpoint to get all registered users
    @GetMapping("/getAllRegistered")
    public List<Registered> listAllRegistered() {
        return registeredService.getAllRegistereds();
    }

    // Additional endpoints can be added as necessary
}
