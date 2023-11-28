package io.group02.fight4flight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.group02.fight4flight.domain.Unregistered;
import io.group02.fight4flight.repository.UnregisteredRepository;
import io.group02.fight4flight.service.UnregisteredService;

@RestController
@RequestMapping("/unregistered")
@CrossOrigin
public class UnregisteredController {
    @Autowired
    private UnregisteredService customerService;
    // @Autowired
    // private UnregisteredRepository customerRpo;

    @PostMapping("/add")
    public String add(@RequestBody Unregistered customer) {
        customerService.saveUnregistered(customer);
        return "Unregistered User Created";
    }

    @GetMapping("/getAll")
    public List<Unregistered> list() {
        return customerService.getAllUnregistereds();
        // return customerRpo.findByEmail("DC@ucalgary.ca");
    }
}