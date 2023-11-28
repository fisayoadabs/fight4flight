package io.group02.fight4flight.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Registered implements GenericCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long registeruserid;
    private String fname;
    private String lname;
    private String address;
    private String email;
    private String username;
    private String password;

    // private Payment payment; // what to do??

    // private ArrayList<Integer> FlightIDs; // What to do??

    // private Map<Date, GenericCustomer> Companions;

    // public Registered(String FName, String MName, String LName, String Email,
    // String Phone, Location Address,
    // String username, String password, String RegisteredUserID, Float
    // discountLounges,
    // ArrayList<Integer> flights, Map<Date, GenericCustomer> Companions) {

    // // sets the rest of the data for the RegisteredUser
    // this.username = username;
    // this.password = password;
    // this.registeruserid = RegisteredUserID;
    // this.FlightIDs = flights;
    // }

    // we can change this to just flight number if we want instead of flight too
    @Override
    public void RegisterFlight(Integer flightID, char row, Integer column) {

    }

    public void RegisterFlight(Integer flight, int row, int num) {
        // Set<Seat> temp = flight.getSeats().keySet();
        // for (Seat s : temp) {
        // if (s.getSeatRow() == row && s.getSeatNum() == num) {
        // if (flight.getSeats().get(s) != null) {
        // System.out.println("Seat is already taken");
        // return;
        // } else {
        // System.out.println("Seat is available");
        // System.out.println("The price is: " + String.valueOf(s.getPrice()));
        // System.out.println(s.getPrice());
        // }
        // flight.getSeats().put(s, this);

        // FutureFlights.put(flight.getFlightNumber(), new Payment(1, "test", new
        // Date(), 0.05f, s.getPrice(), 0));
        // }
        // }
    }

    public void CancelFlight(Integer flight) {
        // for (Map.Entry<Integer, Payment> entry : FutureFlights.entrySet()) {
        // if (entry.getKey() == flight.getFlightNumber()) {
        // for (Seat s : flight.getSeats().keySet()) {
        // if (flight.getSeats().get(s) == this) {
        // flight.getSeats().put(s, null);
        // FutureFlights.remove(entry.getKey());
        // PastFlights.put(entry.getKey(), entry.getValue());
        // Refund(entry.getValue().getTotalPrice());
        // break;
        // }
        // }

        // }
        // }
    }

    public Long getRegisteredUserID() {
        return this.registeruserid;
    }

    public String getFName() {
        return this.fname;
    }

    public String getLName() {
        return this.lname;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAddress() {
        return this.address;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    // public ArrayList<Integer> getFlightID() {
    //     return this.FlightIDs;
    // }

    // public Map<Date, GenericCustomer> getCompanions() {
    //     return this.Companions;
    // }

    public void Refund(float price) {
        System.out.println("Refund of " + String.valueOf(price) + " has been issued");
        // send an email}
    }

    @Override
    public double getDiscountLounges() {
        System.out.println("You area  registered user so you get 30% discount for LOUNGES!!!!!!");
        return 0.30;

    }

    @Override
    public double getRefund() {
        System.out.println("You are a registered user so you get 100% refund!!!");
        return 1.0;
    }
}
