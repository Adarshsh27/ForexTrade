package com.forextrade.microservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Currency_Pairs_Listed")
@Data
public class CurrencyPair {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "base_currency_id")
    private Currency baseCurrency;

    @ManyToOne
    @JoinColumn(name = "quote_currency_id")
    private Currency quoteCurrency;
}
