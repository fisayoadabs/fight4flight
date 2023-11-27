package io.group02.fight4flight.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Customer")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private Long Id;

    private String FName;
    private String LName;
    private String Email;

    public Customer() {}

    public Customer(String FName, String LName, String Email) {
        this.FName = FName;
        this.LName = LName;
        this.Email = Email;
    }

    public Long GetId() {return Id;}

    public String GetFName(){ return this.FName;}

    public String GetLName(){ return this.LName;}

    public String GetEmail(){ return this.Email;}

    public void SetFName(String FName){ this.FName = FName;}

    public void SetLName(String LName){ this.LName = LName;}

    public void SetEmail(String Email){ this.Email = Email;}

    
}
