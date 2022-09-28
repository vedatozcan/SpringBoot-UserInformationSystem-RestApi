package com.springboot.userinfosys.payload;

public class UserDto {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private String aboutMe;
	
	public UserDto(long id, String firstName, String lastName, String email, String username, String password,
			String aboutMe) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.aboutMe = aboutMe;
	}
	
	public UserDto() {
		super();
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
}