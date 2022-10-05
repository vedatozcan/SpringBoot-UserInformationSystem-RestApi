package com.springboot.userinfosys.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.userinfosys.entity.User;
import com.springboot.userinfosys.exception.ResourceNotFoundException;
import com.springboot.userinfosys.payload.UserDto;
import com.springboot.userinfosys.payload.UserResponse;
import com.springboot.userinfosys.repository.UserRepository;
import com.springboot.userinfosys.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private ModelMapper mapper;
	
	 
	public UserServiceImpl(UserRepository userRepository, ModelMapper mapper) {
		this.userRepository = userRepository;
		this.mapper = mapper;
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		// first we need to convert DTO to entity
		User user = mapToEntity(userDto);
		
		// save user to database with userRepository
		User newUser = userRepository.save(user);
		
		// convert user entity to DTO and return 
		UserDto userResponse = mapToDTO(newUser);

		return userResponse;
	}
	
	@Override
	public UserResponse getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir) {
		
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() :  Sort.by(sortBy).descending();

		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		
		Page<User> users = userRepository.findAll(pageable);
		
		// get content from page object
		List<User> listOfUsers = users.getContent();
		 
		List<UserDto> content = listOfUsers.stream().map(user -> mapToDTO(user)).collect(Collectors.toList());
		
		UserResponse userResponse = new UserResponse();
		
		userResponse.setContent(content);
		userResponse.setPageNo(users.getNumber());
		userResponse.setPageSize(users.getSize());
		userResponse.setTotalElements(users.getNumberOfElements());
		userResponse.setTotalPages(users.getTotalPages());
		userResponse.setLast(users.isLast());
			
		return userResponse;
	}

	@Override
	public UserDto getUserById(long id) {
		User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		return mapToDTO(user);
	}

	@Override
	public UserDto updateUser(UserDto userDto, long id) {
		// firstly find user by id with userRepository's findById() method.
		User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setAboutMe(userDto.getAboutMe());
		
		User updatedUser = userRepository.save(user);
		return mapToDTO(updatedUser);
	}

	@Override
	public void deleteUserById(long id) {
		User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		userRepository.delete(user);
	}
	
    private UserDto mapToDTO(User user){
    	UserDto userDto = mapper.map(user, UserDto.class);
    	
//    	UserDto userDto = new UserDto();
//    	userDto.setId(user.getId());
//    	userDto.setFirstName(user.getFirstName());
//    	userDto.setLastName(user.getLastName());
//    	userDto.setEmail(user.getEmail());
//    	userDto.setUsername(user.getUsername());
//    	userDto.setPassword(user.getPassword());
//    	userDto.setAboutMe(user.getAboutMe());

        return userDto;
    }

    private User mapToEntity(UserDto userDto){
    	User user = mapper.map(userDto, User.class);
    	
//    	User user = new User();
//		user.setFirstName(userDto.getFirstName());
//		user.setLastName(userDto.getLastName());
//		user.setEmail(userDto.getEmail());
//		user.setUsername(userDto.getUsername());
//		user.setPassword(userDto.getPassword());
//		user.setAboutMe(userDto.getAboutMe());
    	
        return user;
    }

	
	

}
