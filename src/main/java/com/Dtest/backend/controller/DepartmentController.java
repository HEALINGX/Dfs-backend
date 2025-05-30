package com.Dtest.backend.controller;

import com.Dtest.backend.dto.DepartmentDTO;
import com.Dtest.backend.dto.FileDTO;
import com.Dtest.backend.service.DepartmentService;
import com.Dtest.backend.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // POST สร้าง department ใหม่
    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO dto) {
        DepartmentDTO savedDto = departmentService.saveDepartment(dto);
        return ResponseEntity.ok(savedDto);
    }

    @GetMapping
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    // GET โดย departmentCode
    @GetMapping("/{departmentCode}")
    public ResponseEntity<DepartmentDTO> getDepart(@PathVariable String departmentCode) {
        Optional<DepartmentDTO> dtoOpt = departmentService.getDepartmentById(departmentCode);
        return dtoOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{departmentCode}")
    public ResponseEntity<DepartmentDTO> updateDepartment(
            @PathVariable String departmentCode,
            @RequestBody DepartmentDTO dto) {
        try {
            DepartmentDTO updatedDto = departmentService.updateDepartment(departmentCode, dto);
            return ResponseEntity.ok(updatedDto);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
