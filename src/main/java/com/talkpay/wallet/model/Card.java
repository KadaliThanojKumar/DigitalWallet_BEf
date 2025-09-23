package com.talkpay.wallet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String cardNumber; // last 4 digits
    private String expiryDate; // YYYY-MM
    private String cardholderName;
    private String cvv; // masked e.g. "***"
    private String cardType; // Visa, MasterCard, AMEX
    private Boolean isDefault = false;

    // Constructors
    public Card() {}

    public Card(Long userId, String cardNumber, String expiryDate, String cardholderName, String cvv, String cardType, Boolean isDefault) {
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cardholderName = cardholderName;
        this.cvv = cvv;
        this.cardType = cardType;
        this.isDefault = isDefault;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

    public String getCardholderName() { return cardholderName; }
    public void setCardholderName(String cardholderName) { this.cardholderName = cardholderName; }

    public String getCvv() { return cvv; }
    public void setCvv(String cvv) { this.cvv = cvv; }

    public String getCardType() { return cardType; }
    public void setCardType(String cardType) { this.cardType = cardType; }

    public Boolean getIsDefault() { return isDefault; }
    public void setIsDefault(Boolean isDefault) { this.isDefault = isDefault; }
}
