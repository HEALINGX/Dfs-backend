package com.Dtest.backend.controller;

import com.Dtest.backend.dto.DoctorProfileDetailDTO;
import com.Dtest.backend.model.DoctorDetailsDesc;
import com.Dtest.backend.model.DoctorProfileDetail;
import com.Dtest.backend.service.DoctorProfileDetailService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/doctorProfiles")
public class DoctorProfileDetailController {

    @Autowired
    private DoctorProfileDetailService doctorProfileDetailService;

    @GetMapping("/{code}")
    public ResponseEntity<DoctorProfileDetailDTO> getDoctorProfile(@PathVariable String code) {
        Optional<DoctorProfileDetailDTO> dtoOpt = doctorProfileDetailService.getDoctorProfileDTOByCode(code);
        return dtoOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DoctorProfileDetail> createDoctorProfile(@RequestBody DoctorProfileDetail doctorProfileDetail) {
        DoctorProfileDetail saved = doctorProfileDetailService.saveOrUpdateDoctorProfile(doctorProfileDetail);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{code}")
    public ResponseEntity<DoctorProfileDetail> updateDoctorProfile(@PathVariable String code,
                                                                   @RequestBody DoctorProfileDetailDTO dto) {
        try {
            DoctorProfileDetail updated = doctorProfileDetailService.updateDoctorProfileFromDTO(code, dto);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteDoctorProfile(@PathVariable String code) {
        Optional<DoctorProfileDetail> existingOpt = doctorProfileDetailService.getDoctorProfileByCode(code);
        if (existingOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        doctorProfileDetailService.deleteDoctorProfileByCode(code);
        return ResponseEntity.noContent().build();
    }

}
