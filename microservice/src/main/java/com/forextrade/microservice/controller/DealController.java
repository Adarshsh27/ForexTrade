package com.forextrade.microservice.controller;

import com.forextrade.microservice.dto.DealDTO;
import com.forextrade.microservice.model.Deal;
import com.forextrade.microservice.request.NewDealRequest;
import com.forextrade.microservice.response.ApiResponse;
import com.forextrade.microservice.response.DealListResponse;
import com.forextrade.microservice.service.DealService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class DealController {
    private final DealService dealService;
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addNewDeal(@RequestBody NewDealRequest newDealRequest){
        DealDTO newDeal = dealService.addDeal(newDealRequest);
        return ResponseEntity.ok(new ApiResponse("Deal Added Successfully" , newDeal));
    }
    @GetMapping("/getList")
    public ResponseEntity<ApiResponse> getListOfDeals(@RequestParam Map<String, String> query){
        DealListResponse deals = dealService.getDealsByQuery(query);
        return ResponseEntity.ok(new ApiResponse("Here are the required deals" , deals));
    }

    @GetMapping("/getDeal/{dealId}")
    public ResponseEntity<ApiResponse> getDealDetail(@PathVariable("dealId") Long dealId){
        Deal deal = dealService.getDealById(dealId);
        return ResponseEntity.ok(new ApiResponse("Here is the deal" , deal));
    }
}
