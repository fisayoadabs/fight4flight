package io.group02.fight4flight.model;

import jakarta.persistence.*;

@Entity
public class Pilot extends Unregistered {
    private int pilotid;
    private String address;
    private String username;
    private String password;

    public Pilot(Unregistered user, String address, String username, String password) {
        super(user.getFname(), user.getLname(), user.getEmail());
        this.address = address;
        this.username = username;
        this.password = password;
    }

    public int getPilotId() {
        return pilotid;
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
}
