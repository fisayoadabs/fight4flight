package io.group02.fight4flight.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatid;
    private String seatname;
    private Boolean vacancy;
    private String seattype;
    private Double price;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "aircraftid")
    // @JoinColumn(name = "aircraftid", referencedColumnName = "aircraftid")
    private Aircraft aircraft;

    public Seat() {

    }

    public Long getSeatId() {
        return this.seatid;
    }

    public String getSeatName() {
        return this.seatname;
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

    public void setSeatName(String name) {
        this.seatname = name;
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

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    Seat(String seatType) {
        this.seattype = seatType;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatid=" + seatid +
                ", seatname='" + seatname + '\'' +
                ", vacancy=" + vacancy +
                ", seattype='" + seattype + '\'' +
                ", price=" + price +
                '}';
    }
}
