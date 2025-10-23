package com.tu.localito.app.serviceimpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tu.localito.app.model.Category;
import com.tu.localito.app.model.Product;
import com.tu.localito.app.repository.CategoryRepository;
import com.tu.localito.app.repository.ProductRepository;
import com.tu.localito.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	public ProductServiceImpl(ProductRepository productRepository,CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	
	
	//READ
	@Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }
	@Override
	public Product save(Product product) {
	    Optional<Product> productExisting = productRepository.findBySku(product.getSku());
	    if (productExisting.isPresent()) {
	        throw new IllegalStateException("El SKU del producto ya está registrado: " + product.getSku());
	    }
	    
	    if (product.getCategory() == null || product.getCategory().getId() == null) {
	        throw new IllegalStateException("Debe indicar una categoría válida.");
	    }

	    Category category = categoryRepository.findById(product.getCategory().getId())
	            .orElseThrow(() -> new IllegalStateException(
	                    "La categoría con ID " + product.getCategory().getId() + " no existe."));

	    product.setCategory(category);
	    return productRepository.save(product);
	}
}
