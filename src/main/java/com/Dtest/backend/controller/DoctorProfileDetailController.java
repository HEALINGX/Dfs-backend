package com.Dtest.backend.controller;

import com.Dtest.backend.model.DoctorDetailsDesc;
import com.Dtest.backend.model.DoctorProfileDetail;
import com.Dtest.backend.service.DoctorProfileDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
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
}
