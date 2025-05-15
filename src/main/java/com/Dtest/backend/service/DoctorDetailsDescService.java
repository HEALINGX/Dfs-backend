package com.Dtest.backend.service;

import com.Dtest.backend.model.DoctorDetailsDesc;
import com.Dtest.backend.repository.DoctorDetailsDescRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorDetailsDescService {

    @Autowired
    private DoctorDetailsDescRepo doctorDetailsDescRepo;

    // Create or Update
    public DoctorDetailsDesc saveOrUpdateDoctorDetailsDesc(DoctorDetailsDesc doctorDetailsDesc) {
        return doctorDetailsDescRepo.save(doctorDetailsDesc);
    }
}
