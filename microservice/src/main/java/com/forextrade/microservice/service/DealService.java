package com.forextrade.microservice.service;

import com.forextrade.microservice.dto.DealDTO;
import com.forextrade.microservice.model.Deal;
import com.forextrade.microservice.request.NewDealRequest;
import com.forextrade.microservice.response.DealListResponse;

import java.util.Map;

public class DealService {
    public DealDTO addDeal(NewDealRequest newDealRequest) {
    }

    public DealListResponse getDealsByQuery(Map<String, String> query) {
    }

    public Deal getDealById(Long dealId) {
        return null;
    }
}
