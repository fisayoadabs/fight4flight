package io.group02.fight4flight.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.group02.fight4flight.model.Card;
import io.group02.fight4flight.model.Registered;
import io.group02.fight4flight.model.Ticket;
import io.group02.fight4flight.model.Unregistered;
import io.group02.fight4flight.service.CardService;
import io.group02.fight4flight.service.RegisteredService;
import io.group02.fight4flight.service.TicketService;
import io.group02.fight4flight.service.UnregisteredService;

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

    // Endpoint to add an unregistered user
    @PutMapping("/addUnregistered")
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
    public String register(@RequestBody Registered user) {;
        // Save the Registered user
        registeredService.saveRegistered(user);
        return "User registered successfully";
    }

    // Endpoint to get all registered users
    @GetMapping("/getAllRegistered")
    public List<Registered> listAllRegistered() {
        return registeredService.getAllRegistereds();
    }
    
    // Add card-related endpoints from CardController
    @PostMapping("/{useremail}/addCard")
    public ResponseEntity<String> addCard(@PathVariable Long useremail, @RequestBody Card card) {
        // You can add logic here to associate the card with a user based on userId if
        // needed
        cardService.addCard(card);
        return ResponseEntity.ok("You have added your card");
    }

    @GetMapping("/card/{email}")
    public ResponseEntity<?> getCardByEmail(@PathVariable String email) {
        Optional<Card> card = cardService.getCardByEmail(email);
        if (!card.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(card.get());
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

    
}
