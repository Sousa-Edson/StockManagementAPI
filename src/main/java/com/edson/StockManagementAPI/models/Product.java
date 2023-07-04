package com.edson.StockManagementAPI.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "unit_id")
	@NotNull(message = "Unidade é obrigatório")
	private Unit unit;
	@NotBlank(message = "O nome do produto é obrigatório")
	private String description;
	@NotNull(message = "O valor é obrigatório")
	@PositiveOrZero(message = "O valor deve ser positivo")
	@JsonInclude(Include.NON_NULL)
	private Double value;
	private String generalComments;
	private boolean active;
	@ManyToOne
	@JoinColumn(name = "ncm_id")
	@NotNull(message = "Ncm é obrigatório")
	private NCM ncm;

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public NCM getNcm() {
		return ncm;
	}

	public void setNcm(NCM ncm) {
		this.ncm = ncm;
	}

}
