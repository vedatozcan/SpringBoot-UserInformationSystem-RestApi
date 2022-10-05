package com.springboot.userinfosys.payload;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UserDto {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private String aboutMe;
	private List<AccountDto> accounts;
	
}