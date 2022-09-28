package com.springboot.userinfosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.userinfosys.entity.Tech;

public interface TechRepository extends JpaRepository<Tech, Long> {

}
