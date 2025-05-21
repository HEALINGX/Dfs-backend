package com.Dtest.backend.service;

import com.Dtest.backend.dto.FileDTO;
import com.Dtest.backend.model.DoctorDetailsDesc;
import com.Dtest.backend.model.File;
import com.Dtest.backend.repository.DoctorDetailsDescRepo;
import com.Dtest.backend.repository.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FileService {

    @Autowired
    private FileRepo fileRepository;

    @Autowired
    private DoctorDetailsDescRepo doctorDetailsDescRepo;

    public FileDTO saveFile(FileDTO dto) {
        File file = dtoToEntity(dto);

        DoctorDetailsDesc doctorDetailsDesc = doctorDetailsDescRepo.findById(dto.getDoctorCode())
                .orElseThrow(() -> new RuntimeException("DoctorDetailsDesc not found"));
        file.setDoctorDetailsDesc(doctorDetailsDesc);

        File saved = fileRepository.save(file);
        return entityToDto(saved);
    }

    // หา entity ตาม id (สมมติ id เป็น Long หรือใช้ key อื่น)
    public Optional<FileDTO> getFileById(Long id) {

        return fileRepository.findById(id).map(this::entityToDto);
    }

    public void deleteFileById(Long id) {

        fileRepository.deleteById(id);
    }

    // แปลง DTO → Entity
    private File dtoToEntity(FileDTO dto) {
        File entity = new File();
        entity.setFileSource(dto.getFileSource());
        entity.setUpdateDate(dto.getUpdateDate());
        entity.setUpdateTime(dto.getUpdateTime());
        entity.setFileName(dto.getFileName());

        if (dto.getDoctorCode() != null) {
            DoctorDetailsDesc doctorDetailsDesc = new DoctorDetailsDesc();
            doctorDetailsDesc.setDoctorCode(dto.getDoctorCode());
            entity.setDoctorDetailsDesc(doctorDetailsDesc);
        }

        return entity;
    }

    // แปลง Entity → DTO
    private FileDTO entityToDto(File entity) {
        FileDTO dto = new FileDTO();
        dto.setFileSource(entity.getFileSource());
        dto.setUpdateDate(entity.getUpdateDate());
        dto.setUpdateTime(entity.getUpdateTime());
        dto.setFileName(entity.getFileName());

        if (entity.getDoctorDetailsDesc() != null) {
            dto.setDoctorCode(entity.getDoctorDetailsDesc().getDoctorCode());
        }

        return dto;
    }
}
