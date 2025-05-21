package com.Dtest.backend.service;

import com.Dtest.backend.dto.DepartmentDTO;
import com.Dtest.backend.model.Department;
import com.Dtest.backend.model.DoctorDetailsDesc;
import com.Dtest.backend.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;


    public DepartmentDTO saveDepartment(DepartmentDTO dto) {
        Department department = dtoToEntity(dto);
        Department saved = departmentRepo.save(department);
        return entityToDto(saved);
    }


    public Optional<DepartmentDTO> getDepartmentById(String departmentCode) {
        return departmentRepo.findById(departmentCode).map(this::entityToDto);
    }

    // แปลง DTO → Entity
    private Department dtoToEntity(DepartmentDTO dto) {
        Department entity = new Department();
        entity.setDepartmentCode(dto.getDepartmentCode());
        entity.setDepartmentDesc(dto.getDepartmentDesc());
        entity.setActive(dto.isActive());
        return entity;
    }

    // แปลง Entity → DTO
    private DepartmentDTO entityToDto(Department entity) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setDepartmentCode(entity.getDepartmentCode());
        dto.setDepartmentDesc(entity.getDepartmentDesc());
        dto.setActive(entity.isActive());
        return dto;
    }
}

