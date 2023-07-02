package com.edson.StockManagementAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edson.StockManagementAPI.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
