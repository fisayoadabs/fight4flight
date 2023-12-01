// package io.group02.fight4flight.model;

// import jakarta.persistence.*;

// @Entity
// public class Ticket {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int ticketid;

//     @ManyToOne
//     private Unregistered customer;

//     @ManyToOne
//     private Flight flight;

//     @ManyToOne
//     private Seat seat;

//     // Add other fields or methods as needed

//     public int getTicketid() {
//         return ticketid;
//     }

//     public GenericCustomer getCustomer() {
//         return customer;
//     }

//     public void setCustomer(Unregistered customer) {
//         this.customer = customer;
//     }

//     public Flight getFlight() {
//         return flight;
//     }

//     public void setFlight(Flight flight) {
//         this.flight = flight;
//     }

//     public Seat getSeat() {
//         return seat;
//     }

//     public void setSeat(Seat seat) {
//         this.seat = seat;
//     }

//     // Add other getters and setters as needed
// }
