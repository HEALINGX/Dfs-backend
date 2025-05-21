package com.Dtest.backend.controller;

import com.Dtest.backend.dto.DoctorProfileDetailDTO;
import com.Dtest.backend.dto.DoctorProfileDetailSummaryDTO;
import com.Dtest.backend.model.DoctorProfileDetail;
import com.Dtest.backend.service.DoctorProfileDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/doctorProfiles")
public class DoctorProfileDetailController {

    @Autowired
    private DoctorProfileDetailService doctorProfileDetailService;

    @GetMapping("/{code}")
    public ResponseEntity<DoctorProfileDetailSummaryDTO> getDoctorProfile(@PathVariable String code) {
        Optional<DoctorProfileDetailSummaryDTO> dtoOpt = doctorProfileDetailService.getDoctorProfileDTOByCode(code);
        return dtoOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DoctorProfileDetailDTO> createDoctorProfile(@RequestBody DoctorProfileDetailDTO dto) {
        DoctorProfileDetailDTO savedDto = doctorProfileDetailService.saveDoctorProfile(dto);
        return ResponseEntity.ok(savedDto);
    }

    @PutMapping("/{code}")
    public ResponseEntity<DoctorProfileDetail> updateDoctorProfile(@PathVariable String code,
                                                                   @RequestBody DoctorProfileDetailSummaryDTO dto) {
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
