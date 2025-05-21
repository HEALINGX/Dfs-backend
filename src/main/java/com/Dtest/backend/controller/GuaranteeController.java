package com.Dtest.backend.controller;

import com.Dtest.backend.dto.GuaranteeDTO;
import com.Dtest.backend.service.GuaranteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/guarantees")
public class GuaranteeController {

    @Autowired
    private GuaranteeService guaranteeService;

    // Create a new guarantee
    @PostMapping
    public ResponseEntity<GuaranteeDTO> createGuarantee(@RequestBody GuaranteeDTO dto) {
        GuaranteeDTO created = guaranteeService.createGuarantee(dto);
        return ResponseEntity.ok(created);
    }

    // Get guarantee by ID
    @GetMapping("/{guaranteeTypeCode}")
    public ResponseEntity<GuaranteeDTO> getGuarantee(@PathVariable String guaranteeTypeCode) {
        Optional<GuaranteeDTO> dtoOpt = guaranteeService.getGuaranteeById(guaranteeTypeCode);
        return dtoOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update guarantee by ID
    @PutMapping("/{guaranteeTypeCode}")
    public ResponseEntity<GuaranteeDTO> updateGuarantee(@PathVariable String guaranteeTypeCode, @RequestBody GuaranteeDTO dto) {
        try {
            GuaranteeDTO updated = guaranteeService.updateGuarantee(guaranteeTypeCode, dto);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete guarantee by ID
    @DeleteMapping("/{guaranteeTypeCode}")
    public ResponseEntity<Void> deleteGuarantee(@PathVariable String guaranteeTypeCode) {
        guaranteeService.deleteGuarantee(guaranteeTypeCode);
        return ResponseEntity.noContent().build();
    }
}
