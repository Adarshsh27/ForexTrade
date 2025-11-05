package com.forextrade.microservice.controller;

import com.forextrade.microservice.dto.WalletDTO;
import com.forextrade.microservice.model.Wallet;
import com.forextrade.microservice.request.UpdateWalletRequest;
import com.forextrade.microservice.response.ApiResponse;
import com.forextrade.microservice.service.WalletService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @PatchMapping("/update")
    public ResponseEntity<ApiResponse> updateWallet(@RequestBody UpdateWalletRequest updateWalletRequest){
        WalletDTO wallet = walletService.updateWallet(updateWalletRequest);
        return ResponseEntity.ok(new ApiResponse("Updated wallet" , wallet));
    }

    @GetMapping("/get")
    public ResponseEntity<ApiResponse> getWallet(){
        WalletDTO wallet = walletService.getWallet();
        return ResponseEntity.ok(new ApiResponse("wallet" , wallet));
    }
}
