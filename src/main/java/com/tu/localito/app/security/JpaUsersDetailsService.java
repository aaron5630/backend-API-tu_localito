package com.tu.localito.app.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tu.localito.app.model.Users;
import com.tu.localito.app.repository.UsersRepository;

@Service // ✅ Muy importante para que Spring la detecte como bean
public class JpaUsersDetailsService implements UserDetailsService {

    private final UsersRepository userRepository;

    public JpaUsersDetailsService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override 
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con email: " + email));
        
        System.out.println("🔐 Usuario autenticado: " + user.getEmail());
        user.getRoles().forEach(r -> System.out.println("➡ Rol detectado: " + r.getRolName()));
        
        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRolName().toUpperCase()))
                .collect(Collectors.toSet());

        System.out.println("✅ Authorities asignadas: " + authorities);
        
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }
}