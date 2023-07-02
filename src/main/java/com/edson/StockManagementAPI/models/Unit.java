package com.edson.StockManagementAPI.models;

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
	@NotNull(message = "Unidade é obrigatório")
	@NotBlank(message = "O nome da unidade é obrigatório")
	private String name;
	private boolean active;

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
	
 

}
