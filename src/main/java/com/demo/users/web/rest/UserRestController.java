package com.demo.users.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.users.service.UserService;
import com.demo.users.service.dto.UserDTO;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> save(@RequestBody() UserDTO dto) {
		dto = service.save(dto);
		return ResponseEntity.ok(dto);
	}
}
