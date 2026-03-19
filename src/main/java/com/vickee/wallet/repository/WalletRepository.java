package com.vickee.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vickee.wallet.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>{

}
