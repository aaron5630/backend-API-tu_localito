package com.tu.localito.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tu.localito.app.model.Roles;

public interface RolesRepository extends JpaRepository<Roles,Long>{
	Long findByRolName(String rolName);
}
