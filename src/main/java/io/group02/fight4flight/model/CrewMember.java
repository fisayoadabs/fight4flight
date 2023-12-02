package io.group02.fight4flight.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "CREW_MEMBER")
public class CrewMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long crewid;

    private String fname;
    private String lname;
    private String role;
    private String email;
    private String username;
    private String password;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "flightnumber")
    private Flight flight;

    public CrewMember() {
    }

    public CrewMember(String fname, String lname, String role, String email, String username,
            String password) {
        this.fname = fname;
        this.lname = lname;
        this.role = role;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Long getCrewID() {
        return this.crewid;
    }

    public void setCrewID(Long number) {
        this.crewid = number;
    }

    public String getFName() {
        return this.fname;
    }

    public void setFName(String FName) {
        this.fname = FName;
    }

    public String getLName() {
        return this.lname;
    }

    public void setLName(String LName) {
        this.lname = LName;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String Role) {
        this.role = Role;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}