package com.edson.StockManagementAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edson.StockManagementAPI.models.NCM;
import com.edson.StockManagementAPI.repositories.NCMRepository;

@Service
public class NCMService {

    private final NCMRepository ncmRepository;

    @Autowired
    public NCMService(NCMRepository ncmRepository) {
        this.ncmRepository = ncmRepository;
    }

    public NCM createNCM(NCM ncm) {
        return ncmRepository.save(ncm);
    }

    public List<NCM> getAllNCMs() {
        return ncmRepository.findAll();
    }

    public Optional<NCM> getNCMById(Long id) {
        return ncmRepository.findById(id);
    }

    public NCM updateNCM(Long id, NCM updatedNCM) {
        Optional<NCM> existingNCM = ncmRepository.findById(id);
        if (existingNCM.isPresent()) {
            NCM ncm = existingNCM.get();
            BeanUtils.copyProperties(updatedNCM, ncm, "id");
            return ncmRepository.save(ncm);
        } else {
            return null;
        }
    }

    public boolean deleteNCM(Long id) {
        if (ncmRepository.existsById(id)) {
            ncmRepository.deleteById(id);
            return true;
        } else {
            System.out.println("ERRO deleteNCM");
            return false;
        }
    }

    public boolean existsByCode(String code) {
        if (ncmRepository.existsByCode(code)) {
            return true;
        } else {
            return false;
        }
    }
}
