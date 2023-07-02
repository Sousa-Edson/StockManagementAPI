package com.edson.StockManagementAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edson.StockManagementAPI.models.Movement;

public interface MovementRepository  extends JpaRepository<Movement, Long>   {

}
