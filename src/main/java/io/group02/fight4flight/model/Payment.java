package io.group02.fight4flight.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payid")
    private Long paymentid;

    @OneToOne
    private Card card;

    @OneToOne
    private Flight flight;

    @OneToOne
    private Unregistered user;

    // Getters and Setters for paymentid
    public Long getPaymentId() {
        return paymentid;
    }

    public void setPaymentId(Long paymentid) {
        this.paymentid = paymentid;
    }

    // Getters and Setters for card
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    // Getters and Setters for flight
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    // Getters and Setters for user
    public Unregistered getUser() {
        return user;
    }

    public void setUser(Unregistered user) {
        this.user = user;
    }

    // Other methods and annotations as needed
}
