package com.Dtest.backend.controller;

import com.Dtest.backend.dto.DoctorDetailDescDTO;
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
    public ResponseEntity<DoctorDetailDescDTO> createDoctorDetailsDesc(@RequestBody DoctorDetailDescDTO dto) {
        DoctorDetailDescDTO savedDto = doctorDetailsDescService.saveDoctorDetailsDesc(dto);
        return ResponseEntity.ok(savedDto);
    }

    // GET โดยใช้ doctorCode
    @GetMapping("/{doctorCode}")
    public ResponseEntity<DoctorDetailDescDTO> getDoctorDetailsDesc(@PathVariable String doctorCode) {
        Optional<DoctorDetailDescDTO> dtoOpt = doctorDetailsDescService.getDoctorDetailsDescByCode(doctorCode);
        return dtoOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PUT อัพเดตข้อมูลตาม doctorCode
    @PutMapping("/{doctorCode}")
    public ResponseEntity<DoctorDetailDescDTO> updateDoctorDetailsDesc(@PathVariable String doctorCode,
                                                                        @RequestBody DoctorDetailDescDTO dto) {
        try {
            DoctorDetailDescDTO updatedDto = doctorDetailsDescService.updateDoctorDetailsDesc(doctorCode, dto);
            return ResponseEntity.ok(updatedDto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
