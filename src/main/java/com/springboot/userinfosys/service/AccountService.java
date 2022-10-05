package com.springboot.userinfosys.service;

import java.util.List;

import com.springboot.userinfosys.payload.AccountDto;

public interface AccountService{
	
	AccountDto createAccount(long userId, AccountDto accountDto);
	
	List<AccountDto> getAccountsByUserId(long userId);

    AccountDto getAccountById(long userId, long accountId);
    
    AccountDto updateAccount(long userId, long accountId, AccountDto accountRequest);
    
    void deleteAccount(long userId, long accountId);

}
