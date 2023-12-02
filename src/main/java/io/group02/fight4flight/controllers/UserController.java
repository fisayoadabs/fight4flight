package io.group02.fight4flight.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.group02.fight4flight.model.Card;
import io.group02.fight4flight.model.Payment;
import io.group02.fight4flight.model.Registered;
import io.group02.fight4flight.model.Unregistered;
import io.group02.fight4flight.service.CardService;
import io.group02.fight4flight.service.PaymentService;
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
    @Autowired
    private CardService cardService;
    @Autowired
    private PaymentService paymentService;

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

    // @PostMapping("/{email}/addPayment")
    // public ResponseEntity<?> addPayment(@PathVariable String email, @RequestBody Payment payment) {
    //     if (!email.equals(payment.getEmail())) {
    //         return ResponseEntity.badRequest().body("Email mismatch");
    //     }
    //     Unregistered user = unregisteredService.getByEmail(email);
    //     if (user == null) {
    //         return ResponseEntity.badRequest().body("User not found");
    //     }
    //     Payment newPayment = paymentService.createPayment(payment);
    //     return ResponseEntity.ok(newPayment);
    // }

    // // Endpoint to remove a payment for a registered user
    // @DeleteMapping("/{email}/removePayment/{paymentId}")
    // public ResponseEntity<?> removePayment(@PathVariable String email, @PathVariable Long paymentId) {
    //     Optional<Payment> paymentOptional = paymentService.getPaymentById(paymentId);
    //     if (!paymentOptional.isPresent() || !email.equals(paymentOptional.get().getEmail())) {
    //         return ResponseEntity.badRequest().body("User or Payment not found or email mismatch");
    //     }
    //     paymentService.deletePayment(paymentId);
    //     return ResponseEntity.ok("Payment removed successfully");
    // }

    // @GetMapping("/{email}/payments/{id}")
    // public ResponseEntity<?> getPaymentsByEmail(@PathVariable String email, @PathVariable Long id) {
    //     // Assuming the PaymentService has a method to get payments by email
    //     Optional<Payment> payments = paymentService.getPaymentById(id);
    //     if (payments.isEmpty()) {
    //         return ResponseEntity.notFound().build();
    //     }
    //     Payment payment = payments.get();

    //     // Assuming 'Payment' has a method to get the associated user's email.
    //     // This also assumes that there is a relationship between Payment and User entities.
    //     if (!email.equals(payment.getEmail())) {
    //         return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied for this email");
    //     }

    //     return ResponseEntity.ok(payment);
    // }
    
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
}
