package com.springboot.userinfosys.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "techs")
public class Tech {
	@Id
	@Column(name = "tech_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String techName;
	private String techType;
	private String techFounder;
	
	@ManyToMany(mappedBy = "techs", cascade = CascadeType.ALL)
	private List<Project> projects;
	

}
