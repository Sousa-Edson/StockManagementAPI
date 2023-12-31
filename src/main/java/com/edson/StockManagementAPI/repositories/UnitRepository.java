package com.edson.StockManagementAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.edson.StockManagementAPI.models.Unit;
@Repository
public interface UnitRepository extends JpaRepository<Unit, Long>  {

}
