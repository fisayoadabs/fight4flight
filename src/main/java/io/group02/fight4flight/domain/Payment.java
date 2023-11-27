package io.group02.fight4flight.domain;

import java.util.Date;
import jakarta.persistence.*;

// @Entity
// @Table(name = "PAYMENT")
public class Payment {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "PayID")
    private int PaymentID;
    private String PaymentType;
    private Date PaymentDate;
    private float GST;
    private float TotalPrice;
    private float Discount;

    public Payment(int PaymentID, String PaymentType, Date PaymentDate, float GST, float TotalPrice, float Discount) {
        this.PaymentID = PaymentID;
        this.PaymentType = PaymentType;
        this.PaymentDate = PaymentDate;
        this.GST = GST;
        this.TotalPrice = TotalPrice;
        this.Discount = Discount;
    }

    public float getGST() {
        return this.GST;
    }

    public float getTotalPrice() {
        return this.TotalPrice;
    }

    public float getDiscount() {
        return this.Discount;
    }

    public int getPaymentID() {
        return this.PaymentID;
    }

    public String getPaymentType() {
        return this.PaymentType;
    }

    public Date getPaymentDate() {
        return this.PaymentDate;
    }

    public void setGST(float GST) {
        this.GST = GST;
    }

    public void setTotalPrice(float TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public void setDiscount(float Discount) {
        this.Discount = Discount;
    }

    public void setPaymentID(int PaymentID) {
        this.PaymentID = PaymentID;
    }

    public void setPaymentType(String PaymentType) {
        this.PaymentType = PaymentType;
    }

    public void setPaymentDate(Date PaymentDate) {
        this.PaymentDate = PaymentDate;
    }

}