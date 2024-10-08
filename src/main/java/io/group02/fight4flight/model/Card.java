package io.group02.fight4flight.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardid;
    private Long cardnumber;
    private String cardname;
    private int expiryyear;
    private int expirymonth;
    private int ccv;
    private String email;
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCardid() {
        return cardid;
    }

    public void setCardid(Long cardid) {
        this.cardid = cardid;
    }

    public Long getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(Long cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public int getExpiryyear() {
        return expiryyear;
    }

    public void setExpiryyear(int expiryyear) {
        this.expiryyear = expiryyear;
    }

    public int getExpirymonth() {
        return expirymonth;
    }

    public void setExpirymonth(int expirymonth) {
        this.expirymonth = expirymonth;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

}