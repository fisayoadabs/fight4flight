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
    private Long aircraftid;
    private String aircraftname;
    private String model;
    private int capacity;
    private int aircraftrange;
    private int aircraftspeed;
    private int fuel;
    private int fuelcapacity;

    /*
     * private int businessRows;
     * private int businessCols;
     * private int comfortRows;
     * private int comfortCols;
     * private int ordinaryRows;
     * private int ordinaryCols;
     * 
     * private ArrayList<ArrayList<Seat>> rowsList;
     * 
     * public void MixedRowsWithSeats() {
     * rowsList = new ArrayList<>();
     * 
     * int totalRows = businessRows + comfortRows + ordinaryRows;
     * 
     * for (int i = 0; i < totalRows; i++) {
     * ArrayList<Seat> row = new ArrayList<>();
     * 
     * // Check if the index is within business rows
     * if (i < businessRows) {
     * for (int j = 0; j < businessCols; j++) {
     * row.add(new Seat()); // creates business Seat
     * }
     * }
     * // Check if the index is within comfort rows
     * else if (i < businessRows + comfortRows) {
     * for (int j = 0; j < comfortCols; j++) {
     * row.add(new Seat());
     * }
     * }
     * // Index corresponds to ordinary rows
     * else {
     * for (int j = 0; j < ordinaryCols; j++) {
     * row.add(new Seat());
     * }
     * }
     * 
     * rowsList.add(row);
     * }
     * }
     */

    // List of Business Rows + comfort Rows + ordinary Rows which then has an
    // ArrayList per row. Each index in this list has a list of Arrows based off the
    // number of business cols it has and then comfort cols it has and then ordinary
    // rows
    // What to do for complex data types??
    // private Seat[][] seats;
    // private Map<Date, Boolean> availability;
    // private Location currentLocation;

    // CTOR for inside the java file
    // public Aircraft(String aircraftname, String model, int capacity, int
    // aircraftrange, int
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

    // public ArrayList<ArrayList<Seat>> getSeats() {
    // return this.rowsList;
    // }

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

    // public void setSeats(ArrayList<ArrayList<Seat>> seats) {
    // this.rowsList = seats;
    // }

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
