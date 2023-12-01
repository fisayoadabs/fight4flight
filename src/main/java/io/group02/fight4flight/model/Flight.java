package io.group02.fight4flight.model;
import java.util.ArrayList;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.websocket.OnOpen;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightid;

    @OneToOne
    @JoinColumn(name = "departure") // Ensures it maps to 'departure' column in FLIGHT table
    private AirportCode departure;

    @OneToOne
    @JoinColumn(name = "destination") // Maps to 'destination' column
    private AirportCode destination;

    @ManyToOne
    @JoinColumn(name = "aircraftid") // Maps to 'aircraft' column
    private Aircraft aircraft;

    private LocalDateTime departuretime;
    private LocalDateTime arrivaltime;

    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name="crewid", referencedColumnName = "crewid")
    // private Crew crewid;

    // public Flight(Location Destination, Location Origin, Date DepartureTime, Date
    // ArrivalTime, Aircraft Aircraft, int FlightNumber, Map<Seat, GenericCustomer>
    // Seats){
    // this.Destination = Destination;
    // this.Origin = Origin;
    // this.DepartureTime = DepartureTime;
    // this.ArrivalTime = ArrivalTime;
    // this.Aircraft = Aircraft;
    // this.FlightNumber = FlightNumber;
    // this.Seats = Seats;
    // }

    public Flight() {
        
    }

    public AirportCode getDestination() {
        return this.destination;
    }

    public AirportCode getDeparture() {
        return this.departure;
    }

    public LocalDateTime getDepartureTime() {
        return this.departuretime;
    }

    public LocalDateTime getArrivalTime() {
        return this.arrivaltime;
    }

    public Aircraft getAircraft() {
        return this.aircraft;
    }

    public void setDepartureTime(LocalDateTime day) {
        this.departuretime = day;
    }

    public void setArrivalTime(LocalDateTime day) {
        this.arrivaltime = day;
    }

    public void setDestination(AirportCode place) {
        this.destination = place;
    }

    public void setDeparture(AirportCode place) {
        this.departure = place;
    }

    public void setAircraft(Aircraft craft) {
        this.aircraft = craft;
    }

}
