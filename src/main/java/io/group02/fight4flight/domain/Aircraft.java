package io.group02.fight4flight.domain;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.*;

@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aircraftid;
    private String model;

    @OneToMany(mappedBy="aircraft")
    private List<Seat> seats; //Business: A1-F5, 30 Comfort: A6-F11, 36 Ordinary: A12-F20, 54
    //Total seats: 120

    public int getAircraftID() {
        return this.aircraftid;
    }

    public String getModel() {
        return this.model;
    }

    public List<Seat> getSeats() {
        return this.seats;
    }

    public void setAircraftID(int id) {
        this.aircraftid = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }
}