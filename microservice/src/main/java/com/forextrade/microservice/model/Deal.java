package com.forextrade.microservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "deals")
@Data
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dealId;

    @ManyToOne
    @JoinColumn(name = "base_currency")
    private Currency baseCurrency;

    @ManyToOne
    @JoinColumn(name = "quote_currency")
    private Currency quoteCurrency;

    private Double amount;
    private Double price;
    private Long previousDeal;
    private Long nextDeal;
    private String state;
    private String status;
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private String remark;
}
