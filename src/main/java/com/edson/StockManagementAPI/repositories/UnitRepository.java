package com.edson.StockManagementAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edson.StockManagementAPI.models.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long>  {

}
