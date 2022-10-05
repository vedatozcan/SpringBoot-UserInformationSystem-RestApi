package com.springboot.userinfosys.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.userinfosys.payload.AccountDto;
import com.springboot.userinfosys.service.AccountService;

@RestController
@RequestMapping("/api/v1/users/")
public class AccountController {
	
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	
	@PostMapping("/{userId}/accounts")
	public ResponseEntity<AccountDto> createAccount(@PathVariable(value = "userId") long userId, 
													@RequestBody AccountDto accountDto){
		
		return new ResponseEntity<>(accountService.createAccount(userId, accountDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{userId}/accounts")
	public List<AccountDto> getAccountsByUserId(@PathVariable(value = "userId") long userId){
		
		return accountService.getAccountsByUserId(userId);
	}
	
	@GetMapping("/{userId}/accounts/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable(value = "userId") long userId, 
													 @PathVariable(value = "id") long accountId){
		
		return new ResponseEntity<>(accountService.getAccountById(userId, accountId), HttpStatus.OK);
	}
	
	
	
	@PutMapping("/{userId}/accounts/{id}")
	public ResponseEntity<AccountDto> updateAccount(@PathVariable(value = "userId") long userId, 
													@PathVariable(value = "id") long accountId,
													@RequestBody AccountDto accountRequest){
		
		return new ResponseEntity<>(accountService.updateAccount(userId, accountId, accountRequest), HttpStatus.OK); 
	}

	@DeleteMapping("/{userId}/accounts/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable(value = "userId") long userId,
												@PathVariable(value = "id") long accountId){
		
		accountService.deleteAccount(userId, accountId);
		return new ResponseEntity<>("Account deleted succesfully", HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
