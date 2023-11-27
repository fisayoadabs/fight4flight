package io.group02.fight4flight.domain;

import jakarta.persistence.*;

@Entity
// @Table(name = "Customer")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    // @Column(name = "CustomerID")
    private Long id;

    // @Column(name = "fname")
    private String fname;
    // @Column(name = "lname")
    private String lname;
    // @Column(name = "email")
    private String email;

    // public Customer() {
    // }

    // public Customer(String FName, String LName, String Email) {
    // this.FName = FName;
    // this.LName = LName;
    // this.Email = Email;
    // }

    // public Long getId() {
    // return Id;
    // }

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
        return "Customer{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
