package io.group02.fight4flight.domain;

import jakarta.persistence.*;

@Entity
public class Unregistered implements GenericCustomer{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String fname;
    private String lname;
    private String email;

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Unregistered{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public  double getDiscountLounges(){
        System.out.println("You area  unregistered user so you get NO discount for LOUNGES, you should register!!");
        return 0.0;

    }
     @Override
     public double getRefund() {
         System.out.println("You are an unregistered user so you get 50% refund, you should register for 100%!!!");
         return 0.5;
     }
     @Override 
    public void RegisterFlight(Integer flightID, char row, Integer column){}

}
