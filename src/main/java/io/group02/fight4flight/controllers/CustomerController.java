package io.group02.fight4flight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.group02.fight4flight.domain.Customer;
import io.group02.fight4flight.service.CustomerService;

// @RestController
// @RequestMapping("/customer")
// @CrossOrigin
// public class CustomerController {
//     @Autowired
//     private CustomerService customerService;

//     // @PostMapping("/add")
//     // public String add(@RequestBody Customer customer) {
//     //     customerService.saveCustomer(customer);
//     //     return "New Customer Added";
//     // }
// @PostMapping("/add")
//   public ResponseEntity<String> add(@ModelAttribute("customer") Customer user){

//     customerService.saveCustomer(user);

//     return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
//   }
//     @GetMapping("/getAll")
//     public List<Customer> list() {
//         return customerService.getAllCustomers();
//     }

// }


@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@ModelAttribute("customer") Customer user){
        customerService.saveCustomer(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<Customer> list() {
        return customerService.getAllCustomers();
    }
}