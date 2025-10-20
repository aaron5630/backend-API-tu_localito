package com.tu.localito.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tu.localito.app.model.Users;
import com.tu.localito.app.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	private final UsersService userService;

	public UsersController(UsersService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	ResponseEntity<Users> createdUser(@RequestBody Users user){
		Users createdUser = userService.save(user);
		return ResponseEntity.status(201).body(createdUser);
	}
	
	@PutMapping("/{id}") 
	ResponseEntity<Users> updateById(
			@PathVariable("id")Long id,
			@RequestBody Users user
			){
		Users existingUser = userService.update(id, user);
		return ResponseEntity.ok(existingUser);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<Users> findById(@PathVariable("id") Long id){
		Users existingUser = userService.findById(id);
		return ResponseEntity.ok(existingUser);
	}
	
	@GetMapping 
	ResponseEntity<Iterable<Users>> getAllRoles(){
		return ResponseEntity.ok(userService.findAll());
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Void> deleteById(@PathVariable("id")Long id){
		userService.deleteById(id);
		return ResponseEntity.noContent().build();		
	}
	
}
