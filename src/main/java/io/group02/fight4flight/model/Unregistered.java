package io.group02.fight4flight.model;

import jakarta.persistence.*;

@Entity
@Table(name = "UNREGISTERED")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Unregistered {

    private String fname;
    private String lname;

    @Id
    private String email;

    public Unregistered(){}

    public Unregistered(String fname, String lname, String email) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public double getDiscountLounges() {
        System.out.println("GenericCustomer: You get a default discount for LOUNGES.");
        return 0.1; // Default discount
    }

    public double getRefund() {
        System.out.println("GenericCustomer: You get a default refund.");
        return 0.2; // Default refund
    }

    public void RegisterFlight(Integer flightcustomerid, char row, Integer column) {
        System.out.println("GenericCustomer: Registering for a flight with customerid " + flightcustomerid);
        // Implement flight registration logic for generic customers
    }

}
