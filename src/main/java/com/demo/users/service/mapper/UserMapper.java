package com.demo.users.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.demo.users.domain.UserEntity;
import com.demo.users.service.dto.UserDTO;
import com.demo.users.service.dto.UserFullnameDTO;

@Component
public class UserMapper {
	
	public UserDTO entityToDTO(UserEntity entity) {
		if (entity == null) {
			return null;
		}
		UserDTO dto = new UserDTO();
		dto.setId(entity.getId());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setEmail(entity.getEmail());
		dto.setAddress(entity.getAddress());
		return dto;
	}
	
	public UserFullnameDTO entityToFullnameDTO(UserEntity entity) {
		if (entity == null) {
			return null;
		}
		UserFullnameDTO dto = new UserFullnameDTO();
		dto.setId(entity.getId());
		dto.setFullname(String.format("%s %s", entity.getFirstName(), entity.getLastName()));
		return dto;
		
	}
	
	public UserEntity dtoToEntity(UserDTO dto) {
		if (dto == null) {
			return null;
		}
		UserEntity entity = new UserEntity();
		if(dto.getId()!= null) entity.setId(dto.getId());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());
		entity.setAddress(dto.getAddress());
		return entity;
	}
	
	public List<UserDTO> entityToDTOs(List<UserEntity> entities) { 
		return entities.stream().map(d -> entityToDTO(d)).collect(Collectors.toList());
	}
	
	public List<UserFullnameDTO> entityToFullnameDTOs(List<UserEntity> entities) { 
		return entities.stream().map(d -> entityToFullnameDTO(d)).collect(Collectors.toList());
	}

}
