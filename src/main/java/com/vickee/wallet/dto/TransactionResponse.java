package com.vickee.wallet.dto;

import java.util.List;
import com.vickee.wallet.entity.Transaction;

public class TransactionResponse {
	private Long userId;
    private String userName;
	
    private List<Transaction> transactions;
    
	public TransactionResponse(Long userId, String userName, List<Transaction> transactions) {
		this.userId = userId;
		this.userName = userName;
		this.transactions = transactions;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
}
