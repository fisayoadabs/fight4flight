package io.group02.fight4flight.DTO;

import io.group02.fight4flight.model.Aircraft;

public class AircraftDTO {
    private Long aircraftId;
    private String aircraftName;
    private String model;
    // Add other fields you need in the response, if any

    // Default constructor
    public AircraftDTO() {
    }

    // Parameterized constructor
    public AircraftDTO(Long aircraftId, String aircraftName, String model) {
        this.aircraftId = aircraftId;
        this.aircraftName = aircraftName;
        this.model = model;
    }

    // Getters and setters for each field
    public Long getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(Long aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getAircraftName() {
        return aircraftName;
    }

    public void setAircraftName(String aircraftName) {
        this.aircraftName = aircraftName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public static AircraftDTO fromEntity(Aircraft aircraft) {
    return new AircraftDTO(
        aircraft.getAircraftID(),
        aircraft.getAircraftName(),
        aircraft.getModel());
}

}
