package io.group02.fight4flight.domain;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.*;

@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long aircraftid;
    private String aircraftname;
    private String model;
    private int capacity;
    private int aircraftrange;
    private int aircraftspeed;
    private int fuel;
    private int fuelcapacity;

    // What to do for complex data types??
    // private Seat[][] seats;
    // private Map<Date, Boolean> availability;
    // private Location currentLocation;

    // CTOR for inside the java file
    // public Aircraft(String aircraftname, String model, int capacity, int aircraftrange, int
    // aircraftspeed, int fuel, int fuelCapacity,
    // Seat[][] seats, Map<Date, Boolean> availability, Location currentLocation) {
    // this.aircraftname = aircraftname;
    // this.model = model;
    // this.capacity = capacity;
    // this.aircraftrange = aircraftrange;
    // this.aircraftspeed = aircraftspeed;
    // this.fuel = fuel;
    // this.fuelCapacity = fuelCapacity;
    // this.seats = seats;
    // this.availability = availability;
    // this.currentLocation = currentLocation;
    // }

    public long getAircraftID() {
        return this.aircraftid;
    }

    public String getAircraftname() {
        return this.aircraftname;
    }

    public String getModel() {
        return this.model;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getAircraftRange() {
        return this.aircraftrange;
    }

    public int getAircraftSpeed() {
        return this.aircraftspeed;
    }

    public int getFuel() {
        return this.fuel;
    }

    public int getFuelCapacity() {
        return this.fuelcapacity;
    }

    // public int getFuelCapacity() {
    // return this.fuelCapacity;
    // }

    // public Seat[][] getSeats() {
    // return this.seats;
    // }

    // public Map<Date, Boolean> getAvailability() {
    // return this.availability;
    // }

    // public Location getCurrentLocation() {
    // return this.currentLocation;
    // }

    public void setAircraftID(Long id) {
        this.aircraftid = id;
    }

    public void setaircraftname(String aircraftname) {
        this.aircraftname = aircraftname;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setaircraftrange(int aircraftrange) {
        this.aircraftrange = aircraftrange;
    }

    public void setaircraftSpeed(int aircraftspeed) {
        this.aircraftspeed = aircraftspeed;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelcapacity = fuelCapacity;
    }

    // public void setSeats(Seat[][] seats) {
    // this.seats = seats;
    // }

    // public void setAvailability(Map<Date, Boolean> availability) {
    // this.availability = availability;
    // }

    // public void setCurrentLocation(Location currentLocation) {
    // this.currentLocation = currentLocation;
    // }

}
