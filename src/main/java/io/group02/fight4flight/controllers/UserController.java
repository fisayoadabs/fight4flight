package io.group02.fight4flight.controllers;

import java.util.List;
import java.util.Optional;

import io.group02.fight4flight.service.*;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.group02.fight4flight.model.Admin;
import io.group02.fight4flight.model.Card;
import io.group02.fight4flight.model.Registered;
import io.group02.fight4flight.model.Ticket;
import io.group02.fight4flight.model.Unregistered;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private RegisteredService registeredService;
    @Autowired
    private UnregisteredService unregisteredService;
    @Autowired
    private CardService cardService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private EmailSenderServices sendEmail;

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
        ;
        // Save the Registered user
        registeredService.saveRegistered(user);
        return "User registered successfully";
    }

    // Endpoint to get all registered users
    @GetMapping("/getAllRegistered")
    public List<Registered> listAllRegistered() {
        return registeredService.getAllRegistereds();
    }

    @GetMapping("/getAllCards")
    public List<Card> list() {
        return cardService.getAllCards();
    }

    @PostMapping("/makeCard")
    public  String addCard(@RequestBody Card cad){
        cardService.addCard(cad);
        sendEmail.sendEmail(cad.getEmail(), "Fight4Flight Ticket Purchase", cad.getBody());
        return "Card created email sent";
    }

    // GET endpoint to retrieve all tickets
    @GetMapping("/getAlltickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    // POST endpoint to create a new ticket
    @PostMapping("/tickets")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketService.createTicket(ticket));
    }

    // DELETE endpoint to delete a ticket by ID
    @DeleteMapping("/tickets/{ticketId}")
    public ResponseEntity<?> deleteTicket(@PathVariable Long ticketId) {
        try {
            ticketService.deleteTicket(ticketId);
            return ResponseEntity.ok("Ticket deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket not found");
        }
    }

    // Method to get all admins
    @GetMapping("/getAllAdmins")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    // @PostMapping("/purchaseSeats")
    // public ResponseEntity<?> purchaseSeats(@RequestBody PurchaseRequest purchaseRequest) {
    //     try {
    //         cardService.deductSeatCost(purchaseRequest.getCardId(), purchaseRequest.getSeatCost());
    //         return ResponseEntity.ok("Purchase successful");
    //     } catch (Exception e) {
    //         // Handle exceptions
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during purchase");
    //     }
    // }


}
