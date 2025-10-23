package com.tu.localito.app.serviceimpl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tu.localito.app.model.Roles;
import com.tu.localito.app.model.Users;
import com.tu.localito.app.repository.RolesRepository;
import com.tu.localito.app.repository.UsersRepository;
import com.tu.localito.app.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RolesRepository rolesRepository;

    public UsersServiceImpl(UsersRepository userRepository, PasswordEncoder passwordEncoder, 
    		RolesRepository rolesRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.rolesRepository = rolesRepository;
    }

    // CREATE
    @Override
    public Users save(Users user) {
        Optional<Users> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isEmpty()){
        	
            // TODO: Revisar si creamos el id de rol
        		user.setPassword(passwordEncoder.encode( user.getPassword()) );
        		
        		Set<Roles> roles = new HashSet<>();
        		Roles rolCliente = rolesRepository.findByRolName("Cliente");
        		roles.add(rolCliente);
        		user.setRoles(roles);
        		
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
    public Users update( Long id, Users user) {
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
    
    @Override
    public Users login(String email,String password) {
    		Optional<Users> userExisting = userRepository.findByEmail(email) ;
    		if (userExisting.isEmpty()) {
    			throw new IllegalStateException("Email no registrado");
    		}
    		
    		Users user = userExisting.get();
    		
    		if (!passwordEncoder.matches(password, user.getPassword())) {
    			throw new IllegalStateException("La contraseña no coincide");
    		}
    		
    		return user;
    }
}
