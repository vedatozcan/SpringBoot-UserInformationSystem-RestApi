package com.springboot.userinfosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.userinfosys.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
