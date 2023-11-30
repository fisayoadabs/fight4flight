package io.group02.fight4flight.domain;

import jakarta.persistence.*;

@Entity
public class Seat {
    @Id
    private String seatid;
    private Boolean vacancy;
    private String seattype;
    private Double price;

    //@ManyToOne
    //@JoinColumn(name = "aircraftid")
    //private Aircraft aircraft;

    public Seat() {
        
    }
    public String getSeatId() {
        return this.seatid;
    }
    public Boolean getVacancy() {
        return this.vacancy;
    }

    public String getSeatType() {
        return this.seattype;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setSeatId(String id) {
        this.seatid = id;
    }

    public void setVacancy(Boolean free) {
        this.vacancy = free;
    }

    public void setSeatType(String type) {
        this.seattype = type;
    }

    public void setPrice(Double cost) {
        this.price = cost;
    }

}
