package com.forextrade.microservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {
    private String name;
    @Id
    private String symbol;
    private String country;
}
