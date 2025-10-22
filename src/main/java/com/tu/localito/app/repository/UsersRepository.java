package com.tu.localito.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tu.localito.app.model.Users;

public interface UsersRepository extends JpaRepository<Users,Long>{

	Optional<Users> findByEmail(String email);
}