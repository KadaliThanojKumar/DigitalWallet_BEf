////package com.talkpay.wallet.model;
////
////import jakarta.persistence.*;
////
////@Entity
////@Table(name = "users")
////public class User {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    @Column(unique = true, nullable = false)
////    private String email;
////
////    @Column(nullable = false)
////    private String password;
////
////    public User() {}
////
////    public User(String email, String password) {
////        this.email = email;
////        this.password = password;
////    }
////
////    public Long getId() { return id; }
////    public String getEmail() { return email; }
////    public void setEmail(String email) { this.email = email; }
////    public String getPassword() { return password; }
////    public void setPassword(String password) { this.password = password; }
////}
////
////package com.talkpay.wallet.model;
////
////import jakarta.persistence.*;
////
////@Entity
////@Table(name = "users")
////public class User {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    @Column(unique = true, nullable = false)
////    private String email;
////
////    @Column(nullable = false)
////    private String password;
////
////    @Column(nullable = true)
////    private String name;
////
////    @Column(nullable = true)
////    private String phone;
////
////    public User() {}
////
////    public User(String email, String password) {
////        this.email = email;
////        this.password = password;
////        this.name = "Your Name"; // default
////        this.phone = "1234567890"; // default
////    }
////
////    // Getters and setters
////    public Long getId() { return id; }
////    public String getEmail() { return email; }
////    public void setEmail(String email) { this.email = email; }
////    public String getPassword() { return password; }
////    public void setPassword(String password) { this.password = password; }
////    public String getName() { return name; }
////    public void setName(String name) { this.name = name; }
////    public String getPhone() { return phone; }
////    public void setPhone(String phone) { this.phone = phone; }
////}
//
//package com.talkpay.wallet.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "users")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(unique = true, nullable = false)
//    private String email;
//
//    @Column(nullable = false)
//    private String password;
//
//    private String name;
//    private String phone;
//
//    public User() {}
//
//    public User(String email, String password, String name, String phone) {
//        this.email = email;
//        this.password = password;
//        this.name = name;
//        this.phone = phone;
//    }
//
//    public Long getId() { return id; }
//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }
//    public String getPassword() { return password; }
//    public void setPassword(String password) { this.password = password; }
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//    public String getPhone() { return phone; }
//    public void setPhone(String phone) { this.phone = phone; }
//}

package com.talkpay.wallet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String name;
    private String phone;

    public User() {}

    public User(String email, String password, String name, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}

