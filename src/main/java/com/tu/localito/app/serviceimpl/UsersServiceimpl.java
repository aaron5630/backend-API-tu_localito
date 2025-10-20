package com.tu.localito.app.serviceimpl;

import java.util.Optional;

import com.tu.localito.app.model.Users;
import com.tu.localito.app.repository.UsersRepository;

public class UsersServiceimpl {
	private final UsersRepository userRepository;

	public UsersServiceimpl(UsersRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	// CREATE
	public Users save(Users user) {
		Optional<Users> existingUser = userRepository.findByEmail(user.getEmail());
		if (existingUser.isEmpty()){
			//TODO Revisar si creamos el id de rol. 
			return userRepository.save(user);
		}
		throw new IllegalStateException("El usuario ya está registrado.");
	}
	
	// READ
	public Users findById(Long id) {
		Optional<Users> userOptional = userRepository.findById(id);
		if (userOptional.isEmpty()){
			throw new IllegalStateException("El usuario no existe con id"+id);
		}
		Users existingUser = userOptional.get();
		return existingUser;
	}
	
	public Iterable<Users> findAll(){
		Iterable<Users> users = userRepository.findAll();
		return users;
	}
	//UPDATE
	public Users update(Long id, Users user ){
		Optional<Users> userOptional = userRepository.findById(id);
		if (userOptional.isEmpty()){
			throw new IllegalStateException("El usuario no existe con id"+id);
		}
		Users existingUser = userOptional.get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setPhone(user.getPhone());
		return existingUser;
	}
	
	// DELETE
	public void deleteById(Long id) {
		Optional<Users> userOptional = userRepository.findById(id);
		if (userOptional.isEmpty()){
			throw new IllegalStateException("El usuario no existe con id" + id);
		}
		Users userExisting = userOptional.get();
		userExisting.setActive(false);
	}
}
