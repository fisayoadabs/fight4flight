package io.group02.fight4flight.model;

import jakarta.persistence.*;

@Entity
@Table(name = "UNREGISTERED")
public class Unregistered implements GenericCustomer{

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

    @Override
    public double getDiscountLounges() {
        System.out.println("Unregistered so no lounge privilages");
        return 0.0; // Default discount
    }

    public double getRefund() {
        System.out.println("Unregistered you get 20% refunds");
        return 0.2; // Default refund
    }

    public void RegisterFlight(Integer flightcustomerid, char row, Integer column) {
        System.out.println("GenericCustomer: Registering for a flight with customerid " + flightcustomerid);
        // Implement flight registration logic for generic customers
    }

}
