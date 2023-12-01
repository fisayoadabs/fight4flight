package io.group02.fight4flight.DTO;

import java.time.LocalDateTime;

public class TicketDTO {
    private Long ticketId;
    private String userEmail;
    private Long flightId;
    private Long seatId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String passengerName; // Optional, if you have this data

    // Constructors
    public TicketDTO() {
    }

    // Getters and Setters
    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String user) {
        this.userEmail = user;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
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

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

}
