package io.group02.fight4flight.model;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aircraftid;
    private String aircraftname;
    private String model;

    @OneToMany(mappedBy = "aircraft", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Seat> seats;

    @OneToMany(mappedBy = "aircraftid", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Flight> flights;

    public Aircraft() {
        this.seats = initializeSeats();
    }

    private List<Seat> initializeSeats() {
        List<Seat> seats = new ArrayList<>();

        // Example: creating a mix of business and economy seats
        // Assuming this aircraft will have 30 seats in total

        // Adding business class seats
        for (int i = 0; i < 10; i++) {
            Seat seat = new Seat();
            seat.setSeatName("B" + (i + 1)); // Business seats named B1, B2, B3, ...
            seat.setVacancy(true); // Initially all seats are vacant
            seat.setSeatType("Business");
            seat.setPrice(100.00); // Set price for business class
            seat.setAircraft(this); // Linking seat to this aircraft
            seats.add(seat);
        }

        // Adding economy class seats
        for (int i = 0; i < 20; i++) {
            Seat seat = new Seat();
            seat.setSeatName("E" + (i + 1)); // Economy seats named E1, E2, E3, ...
            seat.setVacancy(true); // Initially all seats are vacant
            seat.setSeatType("Economy");
            seat.setPrice(50.00); // Set price for economy class
            seat.setAircraft(this); // Linking seat to this aircraft
            seats.add(seat);
        }

        return seats;
    }

    public Long getAircraftID() {
        return this.aircraftid;
    }

    public String getAircraftName() {
        return this.aircraftname;
    }

    public String getModel() {
        return this.model;
    }

    public void setAircraftID(Long id) {
        this.aircraftid = id;
    }

    public void setAircraftName(String aircraftname) {
        this.aircraftname = aircraftname;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
        // Set the aircraft reference in each seat
        if (seats != null) {
            for (Seat seat : seats) {
                seat.setAircraft(this);
            }
        }
    }

    public Aircraft orElse(Object object) {
        return null;
    }

}
