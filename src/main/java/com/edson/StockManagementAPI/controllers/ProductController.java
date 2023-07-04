package com.edson.StockManagementAPI.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edson.StockManagementAPI.models.Product;
import com.edson.StockManagementAPI.services.ProductService;
import com.edson.StockManagementAPI.services.UnitService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final UnitService unitService;

    @Autowired
    public ProductController(ProductService productService, UnitService unitService) {
        this.productService = productService;
        this.unitService = unitService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product request, BindingResult bindingResult) {
        // Verificar se há erros de validação
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.add(error.getField() + ": " + error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        if (!unitService.getUnitById(request.getUnit().getId()).isPresent()) {
            return ResponseEntity.status(400).body("A unidade especificada não existe.");
        } else {
            Product savedProduct = productService.createProduct(request);
            return ResponseEntity.status(201).body(savedProduct);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Long id, @Valid @RequestBody Product updatedProduct,
            BindingResult bindingResult) {
        // Verificar se há erros de validação
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.add(error.getField() + ": " + error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        if (!unitService.getUnitById(updatedProduct.getUnit().getId()).isPresent()) {
            return ResponseEntity.status(400).body("A unidade especificada não existe.");
        } else {
            Product updated = productService.updateProduct(id, updatedProduct);
            if (updated != null) {
                return new ResponseEntity<>(updated, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
