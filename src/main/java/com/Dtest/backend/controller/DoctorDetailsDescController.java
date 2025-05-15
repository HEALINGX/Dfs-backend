package com.Dtest.backend.controller;

import com.Dtest.backend.model.DoctorDetailsDesc;
import com.Dtest.backend.service.DoctorDetailsDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doctorDesc")
public class DoctorDetailsDescController {

    @Autowired
    private DoctorDetailsDescService doctorDetailsDescService;

    // POST: Create new DoctorDetailsDesc
    @PostMapping
    public ResponseEntity<DoctorDetailsDesc> createDoctorDetailsDesc(@RequestBody DoctorDetailsDesc doctorDetailsDesc) {
        DoctorDetailsDesc saved = doctorDetailsDescService.saveOrUpdateDoctorDetailsDesc(doctorDetailsDesc);
        return ResponseEntity.ok(saved);
    }

    
}
