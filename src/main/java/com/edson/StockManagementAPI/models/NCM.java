package com.edson.StockManagementAPI.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class NCM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O código do NCM é obrigatório")
    @Size(min = 8, max = 8, message = "O código do NCM deve ter 8 dígitos")
    @Digits(integer = 8, fraction = 0, message = "O código do NCM deve conter apenas números")
    @Column(unique = true)
    private String code;

    @NotBlank(message = "A descrição do NCM é obrigatória")
    @Size(max = 255, message = "A descrição do NCM deve ter no máximo 255 caracteres")
    private String description;

    public NCM() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
