package com.tu.localito.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tu.localito.app.model.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{

}
