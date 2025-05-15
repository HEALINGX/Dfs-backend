// DoctorProfileDetailService.java
package com.Dtest.backend.service;

import com.Dtest.backend.model.DoctorProfileDetail;
import com.Dtest.backend.model.DoctorDetailsDesc;
import com.Dtest.backend.repository.DoctorDetailsDescRepo;
import com.Dtest.backend.repository.DoctorProfileDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DoctorProfileDetailService {

    @Autowired
    private DoctorProfileDetailRepo doctorProfileDetailRepository;

    @Autowired
    private DoctorDetailsDescRepo doctorDetailsDescRepository;

    // Create or Update
    public DoctorProfileDetail saveOrUpdateDoctorProfile(DoctorProfileDetail doctorProfileDetail) {
        return doctorProfileDetailRepository.save(doctorProfileDetail);
    }

    // Method to get DoctorDetailsDesc by DoctorProfileDetail code
    public List<DoctorDetailsDesc> getDoctorDetailsByCode(String code) {
        return doctorDetailsDescRepository.findDoctorByCode(code);
    }

}
