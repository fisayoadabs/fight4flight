package io.group02.fight4flight.domain;

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

    public void setSeatId(Long id) {
        this.seatid = id;
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
}
