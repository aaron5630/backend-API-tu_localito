package com.tu.localito.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tu.localito.app.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
