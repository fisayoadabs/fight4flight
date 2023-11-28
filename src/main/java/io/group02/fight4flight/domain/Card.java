package io.group02.fight4flight.domain;

import java.sql.Date;

public class Card {
    private Long cardid;
    private int cardnumber;
    private String cardname;
    private Date carddate;
    private int ccv;

    public Long getCardId() {
        return this.cardid;
    }

    public int getCardNumber() {
        return this.cardnumber;
    }

    public String getCardName() {
        return this.cardname;
    }

    public Date getCardDate() {
        return this.carddate;
    }

    public int getCcv() {
        return this.ccv;
    }

    public void setCardNumber(int num) {
        this.cardnumber=num;
    }

    public void setCardName(String nom) {
        this.cardname=nom;
    }

    public void setCardDate(Date today) {
        this.carddate = today;
    }

    public void setCcv(int ccv) {
        this.ccv=ccv;
    }
    
}
