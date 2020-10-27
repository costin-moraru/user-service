package com.demo.users.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.users.domain.UserEntity;
import com.demo.users.repository.UserRepository;
import com.demo.users.service.UserService;
import com.demo.users.service.dto.UserDTO;
import com.demo.users.service.dto.UserFullnameDTO;
import com.demo.users.service.mapper.UserMapper;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserMapper mapper;

	@Override
	public List<UserDTO> findAll() {
		List<UserEntity> usersEntities = repository.findAll();
		return mapper.entityToDTOs(usersEntities);
	}

	@Override
	public List<UserFullnameDTO> findAllOnlyFullname() {
		List<UserEntity> usersEntities = repository.findAll();
		return mapper.entityToFullnameDTOs(usersEntities);
	}

	@Override
	public UserDTO save(UserDTO userDTO) {
		UserEntity entity = mapper.dtoToEntity(userDTO);
		entity = repository.save(entity);
		return mapper.entityToDTO(entity);
	}

	@Override
	public void delete(Integer userId) {
		repository.deleteById(userId);
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		UserEntity entity = repository.findOneById(userId);
		return mapper.entityToDTO(entity);
	}

}
