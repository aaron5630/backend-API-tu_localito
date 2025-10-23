package com.tu.localito.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tu.localito.app.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
	Optional <Product> findBySku(String sku);
}
