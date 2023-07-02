package com.edson.StockManagementAPI.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edson.StockManagementAPI.models.Product;
import com.edson.StockManagementAPI.repositories.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	private final UnitService unitService;
	private Validator validator;

	@Autowired
	public ProductService(ProductRepository productRepository, UnitService unitService, Validator validator) {
		this.productRepository = productRepository;
		this.unitService = unitService;
		this.validator = validator;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Long id, Product updatedProduct) {
		Optional<Product> existingProductOptional = productRepository.findById(id);
		if (existingProductOptional.isPresent()) {
			Product existingProduct = existingProductOptional.get();

			existingProduct.setDescription(updatedProduct.getDescription());
			existingProduct.setValue(updatedProduct.getValue());
			existingProduct.setGeneralComments(updatedProduct.getGeneralComments());
			return productRepository.save(existingProduct);
		}
		return null;
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}