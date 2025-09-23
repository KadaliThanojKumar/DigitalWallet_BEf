//package com.talkpay.wallet.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "bills")
//public class Bill {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private Long userId;
//    private String billType;
//    private Double amount;
//    private String status; // Completed, Pending, Failed
//    private LocalDateTime timestamp;
//
//    // Getters and Setters
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public Long getUserId() { return userId; }
//    public void setUserId(Long userId) { this.userId = userId; }
//
//    public String getBillType() { return billType; }
//    public void setBillType(String billType) { this.billType = billType; }
//
//    public Double getAmount() { return amount; }
//    public void setAmount(Double amount) { this.amount = amount; }
//
//    public String getStatus() { return status; }
//    public void setStatus(String status) { this.status = status; }
//
//    public LocalDateTime getTimestamp() { return timestamp; }
//    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
//}
//
//package com.talkpay.wallet.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "bills")
//public class Bill {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private Long userId;
//    private String billName;
//    private double amount;
//    private LocalDateTime paidAt;
//
//    private String status; // <--- Add this
//
//    // Constructors
//    public Bill() {}
//
//    public Bill(Long userId, String billName, double amount, LocalDateTime paidAt, String status) {
//        this.userId = userId;
//        this.billName = billName;
//        this.amount = amount;
//        this.paidAt = paidAt;
//        this.status = status;
//    }
//
//    // Getters and Setters
//    public Long getId() { return id; }
//
//    public Long getUserId() { return userId; }
//    public void setUserId(Long userId) { this.userId = userId; }
//
//    public String getBillName() { return billName; }
//    public void setBillName(String billName) { this.billName = billName; }
//
//    public double getAmount() { return amount; }
//    public void setAmount(double amount) { this.amount = amount; }
//
//    public LocalDateTime getPaidAt() { return paidAt; }
//    public void setPaidAt(LocalDateTime paidAt) { this.paidAt = paidAt; }
//
//    public String getStatus() { return status; }  // <--- Add this
//    public void setStatus(String status) { this.status = status; }  // <--- Add this
//}

package com.talkpay.wallet.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;          // User who paid the bill
    private String billType;      // Type of bill (Electricity, Water, etc.)
    private double amount;        // Amount paid
    private String status;        // Completed / Pending / Failed
    private LocalDateTime paidAt; // Timestamp when paid

    // Constructors
    public Bill() {}

    public Bill(Long userId, String billType, double amount, String status, LocalDateTime paidAt) {
        this.userId = userId;
        this.billType = billType;
        this.amount = amount;
        this.status = status;
        this.paidAt = paidAt;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getBillType() { return billType; }
    public void setBillType(String billType) { this.billType = billType; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getPaidAt() { return paidAt; }
    public void setPaidAt(LocalDateTime paidAt) { this.paidAt = paidAt; }
}
