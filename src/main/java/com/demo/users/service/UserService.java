package com.demo.users.service;

import java.util.List;

import com.demo.users.service.dto.UserDTO;
import com.demo.users.service.dto.UserFullnameDTO;

public interface UserService {
	
	public List<UserDTO> findAll();
	
	public List<UserFullnameDTO> findAllOnlyFullname();
	
	public UserDTO save(UserDTO userDTO);
	
	public void delete(Integer userId);
	
	public UserDTO getUserById(Integer userId);
	

}
