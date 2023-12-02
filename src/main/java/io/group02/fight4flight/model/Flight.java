package io.group02.fight4flight.model;

import java.time.LocalDateTime;
import java.util.Optional;

import jakarta.persistence.*;

@Entity
@Table(name = "FLIGHT")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightid;

    @ManyToOne
    @JoinColumn(name = "departure")
    private AirportCode departure;

    @ManyToOne
    @JoinColumn(name = "destination")
    private AirportCode destination;

    @ManyToOne
    @JoinColumn(name = "aircraftid")
    private Aircraft aircraftid;

    private LocalDateTime departuretime;

    private LocalDateTime arrivaltime;

    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name="crewid", referencedColumnName = "crewid")
    // private Crew crewid;

    public Flight() {
    }

    public Flight(AirportCode num, AirportCode nom, Aircraft craft) {
        this.departure = num;
        this.destination = nom;
        this.aircraftid = craft;
    }

    public Long getFlightid() {
        return flightid;
    }

    public void setFlightid(Long flight) {
        this.flightid = flight;
    }

    public AirportCode getDeparture() {
        return this.departure;
    }

    public void setDeparture(AirportCode place) {
        this.departure = place;
    }

    public AirportCode getDestination() {
        return this.destination;
    }

    public void setDestination(AirportCode place) {
        this.destination = place;
    }

    public Aircraft getAircraft() {
        return this.aircraftid;
    }

    public void setAircraft(Aircraft craft) {
        this.aircraftid = craft;
    }

    public LocalDateTime getDepartureTime() {
        return this.departuretime;
    }

    public void setDepartureTime(LocalDateTime day) {
        this.departuretime = day;
    }

    public LocalDateTime getArrivalTime() {
    return this.arrivaltime;
    }

    public void setArrivalTime(LocalDateTime day) {
    this.arrivaltime = day;
    }

}
