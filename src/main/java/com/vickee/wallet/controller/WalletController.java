package com.vickee.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vickee.wallet.dao.AddRequest;
import com.vickee.wallet.dao.DeductRequest;
import com.vickee.wallet.dto.AddResponse;
import com.vickee.wallet.dto.DeductResponse;
import com.vickee.wallet.dto.TransactionResponse;
import com.vickee.wallet.service.WalletService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/wallet")
@Tag(name = "Wallet APIs", description = "Operations related to wallet management")
public class WalletController {

    @Autowired
    private WalletService walletService;
    
    @Operation(summary = "Add balance to wallet")
    @PostMapping("/add")
    public ResponseEntity<AddResponse> add(@RequestBody AddRequest request) {
        return ResponseEntity.ok(
                walletService.addBalance(request.getWalletId(), request.getAmount())
        );
    }

    @Operation(summary = "Deduct balance from wallet")
    @PostMapping("/deduct")
    public ResponseEntity<DeductResponse> deduct(@Valid @RequestBody DeductRequest request) {
        return ResponseEntity.ok(
                walletService.deductBalance(request.getWalletId(), request.getAmount())
        );
    }

    @Operation(summary = "Get transaction history by wallet ID")
    @GetMapping("/transactions/{walletId}")
    public ResponseEntity<TransactionResponse> transactions(@PathVariable Long walletId) {
        return ResponseEntity.ok(walletService.getTransactions(walletId));
    }
}