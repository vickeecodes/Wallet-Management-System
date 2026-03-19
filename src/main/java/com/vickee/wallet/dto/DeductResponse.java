package com.vickee.wallet.dto;

public class DeductResponse {
	private String Massege;
	private double amount;
	
	public DeductResponse(String Massege,double amount) {
		this.Massege = Massege;
		this.amount = amount;
	}

	public String getMassege() {
		return Massege;
	}

	public void setMassege(String massege) {
		Massege = massege;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
