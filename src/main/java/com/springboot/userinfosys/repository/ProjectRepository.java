package com.springboot.userinfosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.userinfosys.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
