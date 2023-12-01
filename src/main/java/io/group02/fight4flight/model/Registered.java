package io.group02.fight4flight.model;

import jakarta.persistence.*;

@Entity
@Table(name = "REGISTERED")
public class Registered extends Unregistered {

    private int registerid;

    private String address;
    private String username;
    private String password;

    // Add other fields as needed

    public Registered() {
        super();
    }

    public Registered(Unregistered user, String address, String username, String password) {
        super(user.getFname(), user.getLname(), user.getEmail());
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public int getRegisterId() {
        return registerid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Add other getters and setters as needed

    @Override
    public double getDiscountLounges() {
        System.out.println("Registered: You are a registered user, so you get a 30% discount for LOUNGES!");
        return 0.30;
    }

    @Override
    public double getRefund() {
        System.out.println("Registered: You are a registered user, so you get a 100% refund!");
        return 1.0;
    }

    @Override
    public void RegisterFlight(Integer flightID, char row, Integer column) {
        System.out.println("Registered: Registering for a flight with ID " + flightID);
        // Implement flight registration logic for registered customers
    }

    // Additional methods or overrides as needed
}
