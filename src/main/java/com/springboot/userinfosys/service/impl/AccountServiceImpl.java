package com.springboot.userinfosys.service.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springboot.userinfosys.entity.Account;
import com.springboot.userinfosys.entity.User;
import com.springboot.userinfosys.exception.ResourceNotFoundException;
import com.springboot.userinfosys.exception.UserAccountException;
import com.springboot.userinfosys.payload.AccountDto;
import com.springboot.userinfosys.repository.AccountRepository;
import com.springboot.userinfosys.repository.UserRepository;
import com.springboot.userinfosys.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	private AccountRepository accountRepository;
	private UserRepository userRepository;
	private ModelMapper mapper;

	public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository, ModelMapper mapper) {
		this.accountRepository = accountRepository;
		this.userRepository = userRepository;
		this.mapper = mapper;
	}

	@Override
	public AccountDto createAccount(long userId, AccountDto accountDto) {
		
		Account account = mapToEntity(accountDto);
		
		// find user 
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		
		// set user to account entity
		account.setUser(user);
		
		// save account to accountRepository
		Account newAccount = accountRepository.save(account);
				

		AccountDto responseAccount = mapToDTO(newAccount);
		return responseAccount;
	}
	
	@Override
	public List<AccountDto> getAccountsByUserId(long userId) {
		
		List<Account> accounts = accountRepository.findByUserId(userId);
		
		return accounts.stream().map(account -> mapToDTO(account)).collect(Collectors.toList());
	}
	
	@Override
	public AccountDto getAccountById(long userId, long accountId) {
		// retrive user 
		User user = userRepository.findById(userId).
				orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		
		// retrive account
		Account account = accountRepository.findById(accountId).
				orElseThrow(()-> new ResourceNotFoundException("Account", "id", accountId));
		
		if(account.getUser().getId() != user.getId()){
			throw new UserAccountException(HttpStatus.BAD_REQUEST, "Account does not belongs to User");
		}
		return mapToDTO(account);
	}
	
	@Override
	public AccountDto updateAccount(long userId, long accountId, AccountDto accountRequest) {
		User user = userRepository.findById(userId).
				orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		
		Account account = accountRepository.findById(accountId).
				orElseThrow(()-> new ResourceNotFoundException("Account", "id", accountId));
				
		
		if(account.getUser().getId() != user.getId()) {
			throw new UserAccountException(HttpStatus.BAD_REQUEST, "Account does not belongs to User");
		}
		
		account.setAccountName(accountRequest.getAccountName());
		account.setUrl(accountRequest.getUrl());
		
		Account updatedAccount = accountRepository.save(account);
		
		return mapToDTO(updatedAccount);
	}
	

	@Override
	public void deleteAccount(long userId, long accountId) {
		User user = userRepository.findById(userId).
				orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		
		Account account = accountRepository.findById(accountId).
				orElseThrow(()-> new ResourceNotFoundException("Account", "id", accountId));
				
		
		if(account.getUser().getId() != user.getId()) {
			throw new UserAccountException(HttpStatus.BAD_REQUEST, "Account does not belongs to User");
		}
		
		accountRepository.delete(account);
		
	}
	
	 // convert Entity into DTO
    private AccountDto mapToDTO(Account account){
    	AccountDto accountDto = mapper.map(account, AccountDto.class);
    	
//    	AccountDto accountDto = new AccountDto();
//    	accountDto.setId(account.getId());
//    	accountDto.setAccountName(account.getAccountName());
//    	accountDto.setUrl(account.getUrl());
//   
        return accountDto;
    }

    // convert DTO to entity
    private Account mapToEntity(AccountDto accountDto){
    	Account account = mapper.map(accountDto, Account.class);;
    	
//    	Account account = new Account();
//    	account.setAccountName(accountDto.getAccountName());
//    	account.setUrl(accountDto.getUrl());
//		
        return account;
    }
}
