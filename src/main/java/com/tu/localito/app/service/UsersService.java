package com.tu.localito.app.service;

import com.tu.localito.app.model.Users;

public interface UsersService {
	Users save(Users user);
	
	Users findById(Long id);
	
	Iterable<Users> findAll();
	
	Users update(Long id, Users user);
	
	void deleteByID(Long id);
	

}
