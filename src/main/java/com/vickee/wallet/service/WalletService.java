package com.vickee.wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vickee.wallet.dto.DeductResponse;
import com.vickee.wallet.dto.TransactionResponse;
import com.vickee.wallet.dto.AddResponse;
import com.vickee.wallet.entity.Transaction;
import com.vickee.wallet.entity.TransactionType;
import com.vickee.wallet.entity.User;
import com.vickee.wallet.entity.Wallet;
import com.vickee.wallet.exception.InsufficientException;
import com.vickee.wallet.exception.NegativeAmountException;
import com.vickee.wallet.exception.ResourceNotFoundException;
import com.vickee.wallet.repository.TransactionRepository;
import com.vickee.wallet.repository.UserRepository;
import com.vickee.wallet.repository.WalletRepository;

import jakarta.transaction.Transactional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepo;
    
    @Transactional
    public AddResponse addBalance(Long walletId, Double amount) {

        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not found"));

        if(amount > 0) {
        wallet.setBalance(wallet.getBalance() + amount); 
        }
        else {
        	throw new NegativeAmountException("Invalid deposit amount. The amount to add must be greater than zero.");
        }
        Transaction txn = new Transaction();
        txn.setAmount(amount);
        txn.setType(TransactionType.ADD);
        txn.setWallet(wallet);

        transactionRepository.save(txn);
        walletRepository.save(wallet);
        
        return new AddResponse("Amount Added", amount);
    }

    @Transactional
    public DeductResponse deductBalance(Long walletId, Double amount) {

        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not found"));
        
        if (amount <= 0) {
            throw new NegativeAmountException("Amount must be greater than zero");
        } 
        if (wallet.getBalance() < amount) {
            throw new InsufficientException("Insufficient Balance");
        }
        
        wallet.setBalance(wallet.getBalance() - amount);
        Transaction txn = new Transaction();
        txn.setAmount(amount);
        txn.setType(TransactionType.DEDUCT);
        txn.setWallet(wallet);

        transactionRepository.save(txn);
        walletRepository.save(wallet);
        
        return new DeductResponse("Amount Deducted", amount);
    }

    public TransactionResponse getTransactions(Long walletId){
    	User user = userRepo.findById(walletId).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
        List<Transaction> allTransaction = transactionRepository.findAll();
        return new TransactionResponse(walletId, user.getName(),allTransaction);
    }
}