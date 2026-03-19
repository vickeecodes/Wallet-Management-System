package com.vickee.wallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vickee.wallet.entity.Transaction;
import com.vickee.wallet.entity.Wallet;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	List<Transaction> findByWallet(Wallet wallet);
}
