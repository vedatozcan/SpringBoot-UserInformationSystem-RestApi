package com.springboot.userinfosys.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "projects")
public class Project {
	@Id
	@Column(name = "project_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String projectName;
	private String description;
	private Date startTime;
	private Date endTime;
	
	@ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL)
	private List<User> users;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "project_tech", 
		joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "project_id"),
		inverseJoinColumns = @JoinColumn(name = "tech_id", referencedColumnName = "tech_id")
	)
	private List<Tech> techs = new ArrayList<Tech>();
	
}
