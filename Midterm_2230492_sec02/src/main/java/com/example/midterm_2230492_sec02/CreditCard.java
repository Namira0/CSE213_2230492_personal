package com.example.midterm_2230492_sec02;

import java.time.LocalDate;

public class CreditCard {
    private String carNo;
    private String holderName;
    private LocalDate dateOfExpiry;
    private String gateawayName;
    private int CreditLimit;
    private String CardType;

    public CreditCard(String carNo, String holderName, LocalDate dateOfExpiry, String gateawayName, int creditLimit, String cardType) {
        this.carNo = carNo;
        this.holderName = holderName;
        this.dateOfExpiry = dateOfExpiry;
        this.gateawayName = gateawayName;
        CreditLimit = creditLimit;
        CardType = cardType;
    }

    public String getCarNo() {
        return carNo;
    }

    public String getHolderName() {
        return holderName;
    }

    public LocalDate getDateOfExpiry() {
        return dateOfExpiry;
    }

    public String getGateawayName() {
        return gateawayName;
    }

    public int getCreditLimit() {
        return CreditLimit;
    }

    public String getCardType() {
        return CardType;
    }

    public void setCardType(String cardType) {
        CardType = cardType;
    }

    public void setCreditLimit(int creditLimit) {
        CreditLimit = creditLimit;
    }

    public void setGateawayName(String gateawayName) {
        this.gateawayName = gateawayName;
    }

    public void setDateOfExpiry(LocalDate dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "carNo='" + carNo + '\'' +
                ", holderName='" + holderName + '\'' +
                ", dateOfExpiry=" + dateOfExpiry +
                ", gateawayName='" + gateawayName + '\'' +
                ", CreditLimit=" + CreditLimit +
                ", CardType='" + CardType + '\'' +
                '}';
    }
}
