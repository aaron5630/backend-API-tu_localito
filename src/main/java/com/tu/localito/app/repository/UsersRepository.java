package com.tu.localito.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tu.localito.app.model.Users;

public interface UsersRepository extends JpaRepository<Users,Long>{
	 /*Iterable<Users> findByFirstName(String firstName);

	 //Iterable<Users> findAllByActiveTrue();
	 //Iterable<Users> findAllByActiveFalse();

	 //Page<Users> findAllByActiveTrue(Pageable pageable);
	 
	 //Optional<Users> findByEmail(String email);*/
}
