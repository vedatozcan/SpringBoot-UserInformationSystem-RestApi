package com.springboot.userinfosys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.userinfosys.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	List<Account> findByUserId(long userId);

}
