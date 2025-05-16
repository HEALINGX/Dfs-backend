package com.Dtest.backend.service;

import com.Dtest.backend.model.Department;
import com.Dtest.backend.model.DoctorDetailsDesc;
import com.Dtest.backend.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo DepartmentRepo;

    // Create or Update
    public Department saveOrUpdateDepartment(Department department ) {

        return DepartmentRepo.save(department);

    }


}
