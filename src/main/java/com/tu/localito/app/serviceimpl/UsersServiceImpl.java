package com.tu.localito.app.serviceimpl;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tu.localito.app.model.Users;
import com.tu.localito.app.repository.UsersRepository;
import com.tu.localito.app.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // CREATE
    @Override
    public Users save(Users user) {
        Optional<Users> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isEmpty()){
        	
            // TODO: Revisar si creamos el id de rol
        		user.setPassword(passwordEncoder.encode( user.getPassword()) );
            return userRepository.save(user);
        }
        throw new IllegalStateException("El usuario ya está registrado.");
    }

    // READ
    @Override
    public Users findById(Long id) {
        Optional<Users> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()){
            throw new IllegalStateException("El usuario no existe con id " + id);
        }
        return userOptional.get();
    }

    @Override
    public Iterable<Users> findAll() {
        return userRepository.findAll();
    }

    // UPDATE
    @Override
    public Users update(Long id, Users user) {
        Optional<Users> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()){
            throw new IllegalStateException("El usuario no existe con id " + id);
        }
        Users existingUser = userOptional.get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setPhone(user.getPhone());
        existingUser.setPassword(passwordEncoder.encode( user.getPassword()) );
        return userRepository.save(existingUser);
    }

    // DELETE
    @Override
    public void deleteById(Long id) {
        Optional<Users> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()){
            throw new IllegalStateException("El usuario no existe con id " + id);
        }
        Users userExisting = userOptional.get();
        userExisting.setActive(false);
        userRepository.save(userExisting);
    }
}
