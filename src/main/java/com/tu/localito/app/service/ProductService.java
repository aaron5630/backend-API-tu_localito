package com.tu.localito.app.service;

import org.springframework.stereotype.Service;

import com.tu.localito.app.model.Product;
@Service
public interface ProductService {
	Iterable<Product> findAll();
}
