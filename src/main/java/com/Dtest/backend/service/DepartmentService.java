package com.Dtest.backend.service;

import com.Dtest.backend.dto.DepartmentDTO;
import com.Dtest.backend.dto.GuaranteeDTO;
import com.Dtest.backend.model.Department;
import com.Dtest.backend.model.DoctorDetailsDesc;
import com.Dtest.backend.model.Guarantee;
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

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepo.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    public Optional<DepartmentDTO> getDepartmentById(String departmentCode) {
        return departmentRepo.findById(departmentCode).map(this::entityToDto);
    }

    public void updateEntityFromDto(Department entity, DepartmentDTO dto) {

        if (dto.getDepartmentDesc() != null) {
            entity.setDepartmentDesc(dto.getDepartmentDesc());
        }


        entity.setActive(dto.isActive());
    }


    public DepartmentDTO updateDepartment(String departmentCode, DepartmentDTO dto) {
        Department existing = departmentRepo.findById(departmentCode)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        updateEntityFromDto(existing, dto);
        Department saved = departmentRepo.save(existing);
        return entityToDto(saved);
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

