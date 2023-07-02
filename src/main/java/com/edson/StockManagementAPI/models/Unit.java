package com.edson.StockManagementAPI.models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Unit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// private UUID id;
	@NotNull(message = "Unidade é obrigatório")
	@NotBlank(message = "O nome da unidade é obrigatório")
	private String name;

	public Unit() {
		super();
	}

	public Unit(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
	return id;
	}

	public void setId(Long id) {
	this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
 

}
