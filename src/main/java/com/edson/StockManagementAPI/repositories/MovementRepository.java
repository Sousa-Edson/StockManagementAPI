package com.edson.StockManagementAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;   
import org.springframework.stereotype.Repository;
import com.edson.StockManagementAPI.models.Movement;
@Repository
public interface MovementRepository  extends JpaRepository<Movement, Long>   {

}
