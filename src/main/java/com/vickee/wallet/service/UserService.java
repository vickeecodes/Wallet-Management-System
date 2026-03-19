package com.vickee.wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vickee.wallet.dao.LoginRequest;
import com.vickee.wallet.dao.RegisterRequest;
import com.vickee.wallet.dto.LoginResponse;
import com.vickee.wallet.dto.RegisterResponse;
import com.vickee.wallet.entity.User;
import com.vickee.wallet.entity.Wallet;
import com.vickee.wallet.exception.ResourceNotFoundException;
import com.vickee.wallet.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
	this.userRepository = userRepository;
}

	public RegisterResponse register(RegisterRequest request) {
		
		if(userRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new ResourceNotFoundException("Email already exists");
		}
		
		User user = new User();
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		
		Wallet wallet = new Wallet();
		wallet.setUser(user);
		
		user.setWallet(wallet);
		
		userRepository.save(user);
		return new RegisterResponse("User Register Sucssesfully",user.getId());
	}
	
	public LoginResponse login(LoginRequest request) {
		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(()-> new ResourceNotFoundException("Invalid credentials"));
		
		if(!user.getPassword().equals(request.getPassword())) {
			throw new RuntimeException("Invalid credentials");
		}
		return new LoginResponse(user.getId(),user.getName(),user.getEmail(),"User Login Sucssesfull");
	}
}
