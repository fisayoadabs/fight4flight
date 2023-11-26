package io.group02.fight4flight.customer;

public class Customer {
    private String FName;
    private String LName;
    private String Email;
    private Long ID;
    // private Location Address;

    public Customer(String FName, String LName, String Email, Long ID) {
        this.FName = FName;
        this.LName = LName;
        this.Email = Email;
        this.ID = ID;
    }

    public String GetFName(){ return this.FName;}

    public String GetLName(){ return this.LName;}

    public String GetEmail(){ return this.Email;}
    
    public Long GetID() {
        return this.ID;}

    public void SetID(Long ID) {
        this.ID = ID;
    }
    // public GetAddress(){ return this.Address;}

    public void SetFName(String FName){ this.FName = FName;}

    public void SetLName(String LName){ this.LName = LName;}

    public void SetEmail(String Email){ this.Email = Email;}

    
}
