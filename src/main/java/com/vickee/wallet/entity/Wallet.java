package com.vickee.wallet.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data

public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double balance = 0.0;
//	private BigDecimal balance = BigDecimal.ZERO;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
}
