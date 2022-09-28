package com.springboot.userinfosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.userinfosys.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
