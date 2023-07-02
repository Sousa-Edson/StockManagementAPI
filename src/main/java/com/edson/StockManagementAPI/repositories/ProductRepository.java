package com.edson.StockManagementAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edson.StockManagementAPI.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>   {

}
