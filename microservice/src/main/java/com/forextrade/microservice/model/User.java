package com.forextrade.microservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_credentials")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "email_id" , unique = true)
    private String emailId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "password")
    private String password;

    @Column(name = "country")
    private String country;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    public User(String fullName, String password, String country, Wallet wallet) {
        this.fullName = fullName;
        this.password = password;
        this.country = country;
        this.wallet = wallet;
    }

}
