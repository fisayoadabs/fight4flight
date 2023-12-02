package io.group02.fight4flight.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "TICKET")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketid;

    @Column(name = "passenger_email")
    private String passengerEmail;

    @ManyToOne
    @JoinColumn(name = "flightid")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "seatid")
    private Seat seat;

    @Column(name = "departure_location")
    private String departureLocation;

    @Column(name = "destination_location")
    private String destinationLocation;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    // Constructors, getters, and setters

    public Ticket() {
    }

    // Standard getters and setters

    public Long getTicketId() {
        return ticketid;
    }

    public void setTicketId(Long ticketid) {
        this.ticketid = ticketid;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }

    public void setPassengerEmail(String passengerEmail) {
        this.passengerEmail = passengerEmail;
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

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
