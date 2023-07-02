package com.edson.StockManagementAPI.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edson.StockManagementAPI.enums.MovementType;
import com.edson.StockManagementAPI.models.Movement;
import com.edson.StockManagementAPI.repositories.MovementRepository;

@Service
public class MovementService {

    private final MovementRepository movementRepository;

    public MovementService(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public Movement saveMovement(Movement movement) {
        if (movement.getType() == MovementType.IN) {
            movement.setQuantity(Math.abs(movement.getQuantity())); // Transforma em positivo
        } else if (movement.getType() == MovementType.OUT) {
            movement.setQuantity(-Math.abs(movement.getQuantity())); // Transforma em negativo
        }
        return movementRepository.save(movement);
    }

    public List<Movement> getAllMovements() {
        return movementRepository.findAll();
    }

    public Optional<Movement> getMovementById(Long id) {
        return movementRepository.findById(id);
    }

    public void deleteMovement(Long id) {
        movementRepository.deleteById(id);
    }

    public Movement updateMovement(Long id, Movement updatedMovement) {
        Optional<Movement> existingMovementOptional = movementRepository.findById(id);
        if (existingMovementOptional.isPresent()) {
            Movement existingMovement = existingMovementOptional.get();
            System.out.println("MOVIMENTO: " + existingMovementOptional.get().getId());
            existingMovement.setDateTime(LocalDateTime.now());
            existingMovement.setType(updatedMovement.getType());
            existingMovement.setQuantity(updatedMovement.getQuantity());
            existingMovement.setProduct(updatedMovement.getProduct());
            existingMovement.setComplement(updatedMovement.getComplement());

            return movementRepository.save(existingMovement);
        }
        return null;

    }
}
