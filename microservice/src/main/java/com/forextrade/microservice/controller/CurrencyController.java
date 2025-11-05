package com.forextrade.microservice.controller;

import com.forextrade.microservice.request.AddCurrencyPairRequest;
import com.forextrade.microservice.request.AddCurrencyRequest;
import com.forextrade.microservice.response.ApiResponse;
import com.forextrade.microservice.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addCurrencies(@RequestBody AddCurrencyRequest request){
        return ResponseEntity.ok(new ApiResponse("We have added the currencies" , currencyService.addCurrencies(request)));
    }
    @PostMapping("/add/pairs")
    public ResponseEntity<ApiResponse> addCurrencyPairs(@RequestBody AddCurrencyPairRequest request){
        return ResponseEntity.ok(new ApiResponse("WE have added the currency pairs" , currencyService.addCurrencyPairs(request)));
    }

}
