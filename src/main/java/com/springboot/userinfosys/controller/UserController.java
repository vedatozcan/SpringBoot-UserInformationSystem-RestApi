package com.springboot.userinfosys.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.userinfosys.payload.UserDto;
import com.springboot.userinfosys.payload.UserResponse;
import com.springboot.userinfosys.service.UserService;
import com.springboot.userinfosys.utils.AppConstants;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	// create user
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
	}
	
	 // get all users rest api
    @GetMapping
    public UserResponse getAllUsers(@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
    								@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
    								@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
    								@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir){
    	
        return userService.getAllUsers(pageNo, pageSize, sortBy, sortDir);
    }
    
    // get user by id
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
    
    // update user rest api
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable(name = "id") long id){
 
    	UserDto userResponse = userService.updateUser(userDto, id);
    	
    	return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
    
    // delete user rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") long id){

    	userService.deleteUserById(id);

        return new ResponseEntity<>("User entity deleted successfully.", HttpStatus.OK);
    }
    
	
	
	

}
