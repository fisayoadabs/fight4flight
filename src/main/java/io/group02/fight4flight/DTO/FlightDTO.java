package io.group02.fight4flight.DTO;

import java.time.LocalDateTime;

public class FlightDTO {
    private Long flightId;
    private Long departureId;
    private Long destinationId;
    private Long aircraftId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    public FlightDTO() {
    }

    public FlightDTO(Long flight, Long number, Long numbetTwo, Long craftNum, LocalDateTime noon, LocalDateTime dawn) {
        this.flightId = flight;
        this.departureId = number;
        this.destinationId = numbetTwo;
        this.aircraftId = craftNum;
        this.departureTime = noon;
        this.arrivalTime = dawn;
    }

    // Getters and Setters

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long dep) {
        this.flightId = dep;;
    }

    public Long getDepartureId() {
        return departureId;
    }

    public void setDepartureId(Long departureId) {
        this.departureId = departureId;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }

    public Long getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(Long aircraftId) {
        this.aircraftId = aircraftId;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

}
