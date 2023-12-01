package io.group02.fight4flight.model;

import jakarta.persistence.*;

@Entity
public class AirportCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portid;
    private String citystate;
    private String country;
    private String portcode;

    public AirportCode(){}

    public AirportCode(Long portid) {
        this.portid = portid;
    }

    public String getCityState() {
        return this.citystate;
    }

    public String getCountry() {
        return this.country;
    }

    public String getPortCode() {
        return this.portcode;
    }

    public void setCityState(String site) {
        this.citystate = site;
    }

    public void setCountry(String count) {
        this.country = count;
    }

    public void setPortCode(String code) {
        this.portcode = code;
    }
}
