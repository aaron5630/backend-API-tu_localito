package com.tu.localito.app.serviceimpl;

import org.springframework.stereotype.Service;

import com.tu.localito.app.model.Product;
import com.tu.localito.app.repository.ProductRepository;
import com.tu.localito.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	
	//READ
	@Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }
	
}
