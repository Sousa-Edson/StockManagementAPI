package com.edson.StockManagementAPI.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "unit_id")
	// @NotNull(message = "Unidade é obrigatório")
	private Unit unit;
	@NotBlank(message = "O nome do produto é obrigatório")
	private String description;
	private double value;
	private String generalComments;

	// Construtores, getters e setters

	public Product() {
	}

	public Product(Unit unit, String description, double value, String generalComments) {
		this.unit = unit;
		this.description = description;
		this.value = value;
		this.generalComments = generalComments;
	}

	// getters e setters dos campos

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getGeneralComments() {
		return generalComments;
	}

	public void setGeneralComments(String generalComments) {
		this.generalComments = generalComments;
	}

}
