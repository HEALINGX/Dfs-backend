package com.Dtest.backend.controller;

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

    // POST: Create new DoctorProfileDetail
    @PostMapping
    public ResponseEntity<DoctorProfileDetail> createDoctorProfile(@RequestBody DoctorProfileDetail doctorProfileDetail) {
        DoctorProfileDetail saved = doctorProfileDetailService.saveOrUpdateDoctorProfile(doctorProfileDetail);
        System.out.println("Post data :" + saved);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{code}")
    public List<DoctorDetailsDesc> getDoctorDetailsByCode(@PathVariable String code) {
        return doctorProfileDetailService.getDoctorDetailsByCode(code);
    }

    @GetMapping("single/{code}")
    public ResponseEntity<DoctorProfileDetail> getDoctorProfile(@PathVariable String code) {
        Optional<DoctorProfileDetail> doctorProfileOpt = doctorProfileDetailService.getDoctorProfileByCode(code);
        return doctorProfileOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("single/{code}")
    public ResponseEntity<DoctorProfileDetail> updateDoctorProfile(@PathVariable String code,
                                                                   @RequestBody DoctorProfileDetail updatedDoctorProfile) {
        Optional<DoctorProfileDetail> existingOpt = doctorProfileDetailService.getDoctorProfileByCode(code);
        if (existingOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        DoctorProfileDetail existing = existingOpt.get();

        // อัพเดตฟิลด์ที่ต้องการ
        existing.setUserId(updatedDoctorProfile.getUserId());
        existing.setTelephone(updatedDoctorProfile.getTelephone());
        // ... อัพเดตฟิลด์อื่น ๆ ที่ต้องการ

        // อัพเดตความสัมพันธ์อย่างระมัดระวัง
        if (updatedDoctorProfile.getDoctorDetailsDescs() != null) {
            existing.getDoctorDetailsDescs().clear();
            existing.getDoctorDetailsDescs().addAll(updatedDoctorProfile.getDoctorDetailsDescs());
            // ต้องตั้ง doctorProfileDetail ให้ถูกต้องในแต่ละ DoctorDetailsDesc ด้วย
            for (DoctorDetailsDesc desc : existing.getDoctorDetailsDescs()) {
                desc.setDoctorProfileDetail(existing);
            }
        }

        DoctorProfileDetail saved = doctorProfileDetailService.saveOrUpdateDoctorProfile(existing);
        return ResponseEntity.ok(saved);
    }


    // DELETE DoctorProfileDetail by code
    @DeleteMapping("/{code}")
    @Transactional
    public ResponseEntity<Void> deleteDoctorProfile(@PathVariable String code) {
        Optional<DoctorProfileDetail> existing = doctorProfileDetailService.getDoctorProfileByCode(code);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        doctorProfileDetailService.deleteDoctorProfileByCode(code);
        return ResponseEntity.noContent().build();
    }

}
