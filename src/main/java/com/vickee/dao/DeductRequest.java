package com.vickee.dao;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

//public class DeductRequest {
//	private Long walletId;
//	private Double amount;
//	
//	public Long getWalletId() {
//		return walletId;
//	}
//	public void setWalletId(Long walletId) {
//		this.walletId = walletId;
//	}
//	public Double getAmount() {
//		return amount;
//	}
//	public void setAmount(Double amount) {
//		this.amount = amount;
//	}	
//}

@Data
public class DeductRequest {

    @NotNull(message = "Wallet ID is required")
    private Long walletId;

    @NotNull(message = "Amount is required")
    @Min(value = 1, message = "Amount must be greater than 0")
    private Double amount;
}
