package io.group02.fight4flight.DTO;

public class CrewDTO {
    private Long crewMemberId;
    private Long flightId;

    // Getters and setters
    public Long getCrewMemberId() {
        return crewMemberId;
    }

    public void setCrewMemberId(Long crewMemberId) {
        this.crewMemberId = crewMemberId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
}
