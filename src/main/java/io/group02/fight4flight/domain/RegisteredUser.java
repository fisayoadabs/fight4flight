// package io.group02.fight4flight.domain;

// import java.util.ArrayList;
// import java.util.Date;
// import java.util.Map;
// import java.util.Set;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "REGISTERED_USER")
// @SecondaryTable(name = "Customer", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))

// public class RegisteredUser extends Customer {
//     private String username;
//     private String password;
//     @Column(name = "RegisteredID")
//     private String RegisteredUserID;
//     private Payment payment;
//     private Float discountLounges;

//     private ArrayList<Integer> FlightIDs;

//     private Map<Date, Customer> Companions;

//     public RegisteredUser(String FName, String MName, String LName, String Email, String Phone, Location Address,
//             String username, String password, String RegisteredUserID, Float discountLounges,
//             ArrayList<Integer> flights, Map<Date, Customer> Companions) {
//         super(FName, LName, Email); // call the constructor of the superclass Customer

//         // sets the rest of the data for the RegisteredUser
//         this.username = username;
//         this.password = password;
//         this.RegisteredUserID = RegisteredUserID;
//         this.discountLounges = discountLounges;
//         this.FlightIDs = flights;
//     }

//     // we can change this to just flight number if we want instead of flight too
//     public void RegisterFlight(Flight flight, int row, char num) {
//         Set<Seat> temp = flight.getSeats().keySet();
//         for (Seat s : temp) {
//             if (s.getSeatRow() == row && s.getSeatNum() == num) {
//                 if (flight.getSeats().get(s) != null) {
//                     System.out.println("Seat is already taken");
//                     return;
//                 } else {
//                     System.out.println("Seat is available");
//                     System.out.println("The price is: " + String.valueOf(s.getPrice()));
//                     System.out.println(s.getPrice());
//                 }
//                 flight.getSeats().put(s, this);

//                 FutureFlights.put(flight.getFlightNumber(), new Payment(1, "test", new Date(), 0.05f, s.getPrice(), 0));
//             }
//         }
//     }

//     public void CancelFlight(Flight flight) {
//         for (Map.Entry<Integer, Payment> entry : FutureFlights.entrySet()) {
//             if (entry.getKey() == flight.getFlightNumber()) {
//                 for (Seat s : flight.getSeats().keySet()) {
//                     if (flight.getSeats().get(s) == this) {
//                         flight.getSeats().put(s, null);
//                         FutureFlights.remove(entry.getKey());
//                         PastFlights.put(entry.getKey(), entry.getValue());
//                         Refund(entry.getValue().getTotalPrice());
//                         break;
//                     }
//                 }

//             }
//         }
//     }

//     public void Refund(float price) {
//         System.out.println("Refund of " + String.valueOf(price) + " has been issued");
//         // send an email}
//     }

//     public String getUsername() {
//         return this.username;
//     }

//     public String getPassword() {
//         return this.password;
//     }

//     public String getRegisteredUserID() {
//         return this.RegisteredUserID;
//     }

//     public Float getDiscountLounges() {
//         return this.discountLounges;
//     }

//     public Map<Integer, Payment> getFutureFlights() {
//         return this.FutureFlights;
//     }

//     public Map<Integer, Payment> getPastFlights() {
//         return this.PastFlights;
//     }

//     public Map<Date, Customer> getCompanions() {
//         return this.Companions;
//     }

// }
