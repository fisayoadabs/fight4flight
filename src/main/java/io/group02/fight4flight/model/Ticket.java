package io.group02.fight4flight.model;

import jakarta.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketid;

    @ManyToOne
    @JoinColumn(name = "passemail")
    private Unregistered user; // The user associated with this ticket

    @ManyToOne
    @JoinColumn(name = "flightid", nullable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "seatid", nullable = false)
    private Seat seat;

    // Constructors, getters and setters

    public Ticket() {
    }

    public Long getTicketId() {
        return ticketid;
    }

    public String getUser() {
        return user.getEmail();
    }

    public void setUser(Unregistered user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
