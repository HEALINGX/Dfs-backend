package com.Dtest.backend.controller;

import com.Dtest.backend.dto.DoctorDetailsDescDTO;
import com.Dtest.backend.dto.DoctorDetailsDescSummaryDTO;
import com.Dtest.backend.service.DoctorDetailsDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/doctorDetails")
public class DoctorDetailsDescController {

    @Autowired
    private DoctorDetailsDescService doctorDetailsDescService;

    // POST สร้างใหม่
    @PostMapping
    public ResponseEntity<DoctorDetailsDescDTO> createDoctorDetailsDesc(@RequestBody DoctorDetailsDescDTO dto) {
        DoctorDetailsDescDTO savedDto = doctorDetailsDescService.saveDoctorDetailsDesc(dto);
        return ResponseEntity.ok(savedDto);
    }

    // GET โดยใช้ doctorCode
    @GetMapping("/{doctorCode}")
    public ResponseEntity<DoctorDetailsDescSummaryDTO> getDoctorDetailsDesc(@PathVariable String doctorCode) {
        Optional<DoctorDetailsDescSummaryDTO> dtoOpt = doctorDetailsDescService.getDoctorDetailsDescByCode(doctorCode);
        return dtoOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PUT อัพเดตข้อมูลตาม doctorCode
    @PutMapping("/{doctorCode}")
    public ResponseEntity<DoctorDetailsDescSummaryDTO> updateDoctorDetailsDesc(@PathVariable String doctorCode,
                                                                               @RequestBody DoctorDetailsDescSummaryDTO dto) {
        try {
            DoctorDetailsDescSummaryDTO updatedDto = doctorDetailsDescService.updateDoctorDetailsDesc(doctorCode, dto);
            return ResponseEntity.ok(updatedDto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{doctorCode}")
    public ResponseEntity<Void> deleteDoctorDetailsDescByCode(@PathVariable String doctorCode) {
        doctorDetailsDescService.deleteDoctorDetailsDescByCode(doctorCode);
        return ResponseEntity.noContent().build();
    }
}
