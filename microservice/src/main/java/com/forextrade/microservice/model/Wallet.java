package com.forextrade.microservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "wallet")
@Data
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wallet_id")
    private Long walletId;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "wallet_balance" , joinColumns = @JoinColumn(name = "wallet_id"))
    @MapKeyJoinColumn(name = "currency_symbol")
    @Column(name = "amount")
    private Map<Currency, Double> balance;

    @OneToOne(mappedBy = "wallet")
    private User user;

    public Map<Currency, Double> getBalance(){
        if(balance == null){
            balance = new HashMap<>();
        }
        return balance;
    }
}
