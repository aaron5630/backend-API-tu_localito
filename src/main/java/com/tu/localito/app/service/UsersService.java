package com.tu.localito.app.service;

import org.springframework.stereotype.Service;

import com.tu.localito.app.model.Users;
@Service
public interface UsersService {
	Users save(Users user);
	
	Users findById(Long id);
	
	Iterable<Users> findAll();
	
	Users update(Long id, Users user);
	
	void deleteById(Long id);
	
	Users login(String email, String password);
	
}
