package com.Dtest.backend.controller;

import com.Dtest.backend.dto.FileDTO;
import com.Dtest.backend.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileService fileService;

    // POST สร้างไฟล์ใหม่
    @PostMapping
    public ResponseEntity<FileDTO> createFile(@RequestBody FileDTO dto) {
        FileDTO savedDto = fileService.saveFile(dto);
        return ResponseEntity.ok(savedDto);
    }

    // GET โดย id
    @GetMapping("/{id}")
    public ResponseEntity<FileDTO> getFile(@PathVariable Long id) {
        Optional<FileDTO> dtoOpt = fileService.getFileById(id);
        return dtoOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
