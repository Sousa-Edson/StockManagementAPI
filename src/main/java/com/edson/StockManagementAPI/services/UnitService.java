package com.edson.StockManagementAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edson.StockManagementAPI.models.Unit;
import com.edson.StockManagementAPI.repositories.UnitRepository;

@Service
public class UnitService {

	private final UnitRepository unitRepository;

	@Autowired
	public UnitService(UnitRepository unitRepository) {
		this.unitRepository = unitRepository;
	}

	public List<Unit> getAllUnits() {
		return unitRepository.findAll();
	}

	public Optional<Unit> getUnitById(Long id) {
		return unitRepository.findById(id);
	}

	public Unit createUnit(Unit unit) {
		return unitRepository.save(unit);
	}

	public Unit updateUnit(Long id, Unit unit) {
		Optional<Unit> existingUnit = unitRepository.findById(id);
		if (existingUnit.isPresent()) {
			unit.setId(id);
			return unitRepository.save(unit);
		}
		return null; // or throw an exception indicating the unit does not exist
	}

	public void deleteUnit(Long id) {
		unitRepository.deleteById(id);
	}

}
