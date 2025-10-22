package com.tu.localito.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tu.localito.app.model.Product;
import com.tu.localito.app.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	} 
	
	@GetMapping 
	ResponseEntity<Iterable<Product>> getAllProduct(){
		return ResponseEntity.ok(productService.findAll());
	}
	
}
