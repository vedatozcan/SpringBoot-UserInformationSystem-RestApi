package com.springboot.userinfosys.service;

import com.springboot.userinfosys.payload.UserDto;
import com.springboot.userinfosys.payload.UserResponse;

public interface UserService {
	
	UserDto createUser(UserDto userDto);
	
	UserResponse getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir);
	
	UserDto getUserById(long id);
	
	UserDto updateUser(UserDto userDto, long id);
	
	void deleteUserById(long id);

}
