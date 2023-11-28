package io.group02.fight4flight.domain;
import java.sql.Date;
import java.util.Map;

import jakarta.persistence.*;

@Entity
public class Flight{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long FlightID;
    private Location Destination;
    private Location Origin;
    private Date DepartureTime;
    private Date ArrivalTime;
    private Aircraft Aircraft;
    private int FlightNumber;

    


    // public Flight(Location Destination, Location Origin, Date DepartureTime, Date ArrivalTime, Aircraft Aircraft, int FlightNumber, Map<Seat, GenericCustomer> Seats){
    //     this.Destination = Destination;
    //     this.Origin = Origin;
    //     this.DepartureTime = DepartureTime;
    //     this.ArrivalTime = ArrivalTime;
    //     this.Aircraft = Aircraft;
    //     this.FlightNumber = FlightNumber;
    //     this.Seats = Seats;
    // }

    public Location getDestination(){ return this.Destination;}
    public Location getOrigin(){ return this.Origin;}
    public Date getDepartureTime(){ return this.DepartureTime;}
    public Date getArrivalTime(){ return this.ArrivalTime;}
    public Aircraft getAircraft(){ return this.Aircraft;}
    public int getFlightNumber(){ return this.FlightNumber;}
    
    
} 