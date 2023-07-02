package com.edson.StockManagementAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edson.StockManagementAPI.models.NCM;

@Repository
public interface NCMRepository extends JpaRepository<NCM, Long> {

}