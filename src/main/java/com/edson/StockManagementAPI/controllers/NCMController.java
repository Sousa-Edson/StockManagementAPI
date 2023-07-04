package com.edson.StockManagementAPI.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edson.StockManagementAPI.models.NCM;
import com.edson.StockManagementAPI.services.NCMService;

@RestController
@RequestMapping("/api/ncm")
public class NCMController {

    private final NCMService ncmService;

    @Autowired
    public NCMController(NCMService ncmService) {
        this.ncmService = ncmService;
    }

    @GetMapping
    public ResponseEntity<List<NCM>> getAllNCMs() {
        List<NCM> ncms = ncmService.getAllNCMs();
        return new ResponseEntity<>(ncms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NCM> getNCMById(@PathVariable("id") Long id, @RequestBody NCM updatedNcm) {
        Optional<NCM> ncm = ncmService.getNCMById(id);
        if (ncm != null) {
            // NCM updated = ncmService.updateNCM(id, updatedNcm);
            return new ResponseEntity<>(updatedNcm, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createNCM(@Valid @RequestBody NCM ncm, BindingResult bindingResult) {
        // Verificar se há erros de validação
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.add(error.getField() + ": " + error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        if (ncmService.existsByCode(ncm.getCode())) {
            return ResponseEntity.status(400).body("O código do NCM já existe: " + ncm.getCode());
        }
        // if (!ncm.getCode().matches("\\d{8}")) {
        // return ResponseEntity.badRequest().body("O campo 'codigo' deve conter
        // exatamente 8 dígitos.");
        // }
        // if (ncm.getDescription().isBlank()) {
        // return ResponseEntity.badRequest().body("O campo 'descrição' não pode ser
        // vazio.");
        // }

        NCM create = ncmService.createNCM(ncm);
        if (create != null) {
            return ResponseEntity.status(201).body(create);
        }

        return ResponseEntity.badRequest().body("Ocorreu um erro");
    }

    @PutMapping("/{id}")
    public ResponseEntity<NCM> updateNCM(@PathVariable Long id, @RequestBody NCM ncm) {
        NCM updatedNCM = ncmService.updateNCM(id, ncm);
        if (updatedNCM != null) {
            return new ResponseEntity<>(updatedNCM, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNCM(@PathVariable Long id) {
        boolean deleted = ncmService.deleteNCM(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
