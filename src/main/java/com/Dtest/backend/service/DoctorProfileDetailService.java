package com.Dtest.backend.service;

import com.Dtest.backend.dto.DoctorProfileDetailDTO;
import com.Dtest.backend.dto.DoctorProfileDetailSummaryDTO;
import com.Dtest.backend.mapper.DoctorProfileDetailMapper;
import com.Dtest.backend.model.DoctorProfileDetail;
import com.Dtest.backend.model.DoctorDetailsDesc;
import com.Dtest.backend.repository.DoctorProfileDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorProfileDetailService {

    @Autowired
    private DoctorProfileDetailRepo doctorProfileDetailRepo;

    // คืน Entity (ใช้ภายใน service สำหรับ save/update)
    public Optional<DoctorProfileDetail> getDoctorProfileByCode(String code) {
        return doctorProfileDetailRepo.findByCode(code);
    }

    public DoctorProfileDetail updateDoctorProfileFromDTO(String code, DoctorProfileDetailSummaryDTO dto) {
        Optional<DoctorProfileDetail> existingOpt = doctorProfileDetailRepo.findById(code);
        if (existingOpt.isEmpty()) {
            throw new RuntimeException("DoctorProfileDetail not found");
        }
        DoctorProfileDetail existing = existingOpt.get();

        // อัพเดตฟิลด์ทั่วไป
        existing.setUserId(dto.getUserId());
        existing.setTelephone(dto.getTelephone());
        existing.setEmployeeId(dto.getEmployeeId());
        existing.setLicenseId(dto.getLicenseId());
        existing.setNameEng(dto.getNameEng());
        existing.setActive(dto.isActive());
        existing.setUpdateDate(dto.getUpdateDate());
        existing.setUpdateTime(dto.getUpdateTime());
        existing.setNationId(dto.getNationId());
        existing.setNameThai(dto.getNameThai());
        existing.setBirthDate(dto.getBirthDate());
        existing.setHospitalCode(dto.getHospitalCode());

        // บันทึกและรีเทิร์น entity พร้อมความสัมพันธ์ครบถ้วน
        DoctorProfileDetail saved = doctorProfileDetailRepo.save(existing);

        // บังคับโหลด doctorDetailsDescs (ถ้า fetch เป็น LAZY)
        saved.getDoctorDetailsDescs().size();

        return saved;
    }



    // คืน DTO
    public Optional<DoctorProfileDetailSummaryDTO> getDoctorProfileDTOByCode(String code) {
        return doctorProfileDetailRepo.findByCode(code)
                .map(DoctorProfileDetailMapper::toDTO);
    }


    public DoctorProfileDetailDTO saveDoctorProfile(DoctorProfileDetailDTO dto) {
        DoctorProfileDetail entity = new DoctorProfileDetail();
        entity.setCode(dto.getCode());
        entity.setUserId(dto.getUserId());
        entity.setTelephone(dto.getTelephone());
        entity.setEmployeeId(dto.getEmployeeId());
        entity.setLicenseId(dto.getLicenseId());
        entity.setNameEng(dto.getNameEng());
        entity.setActive(dto.isActive());
        entity.setUpdateDate(dto.getUpdateDate());
        entity.setUpdateTime(dto.getUpdateTime());
        entity.setNationId(dto.getNationId());
        entity.setNameThai(dto.getNameThai());
        entity.setBirthDate(dto.getBirthDate());
        entity.setHospitalCode(dto.getHospitalCode());

        DoctorProfileDetail saved = doctorProfileDetailRepo.save(entity);

        // แปลง entity เป็น DTO แบบ manual
        DoctorProfileDetailDTO savedDto = new DoctorProfileDetailDTO();
        savedDto.setCode(saved.getCode());
        savedDto.setUserId(saved.getUserId());
        savedDto.setTelephone(saved.getTelephone());
        savedDto.setEmployeeId(saved.getEmployeeId());
        savedDto.setLicenseId(saved.getLicenseId());
        savedDto.setNameEng(saved.getNameEng());
        savedDto.setActive(saved.isActive());
        savedDto.setUpdateDate(saved.getUpdateDate());
        savedDto.setUpdateTime(saved.getUpdateTime());
        savedDto.setNationId(saved.getNationId());
        savedDto.setNameThai(saved.getNameThai());
        savedDto.setBirthDate(saved.getBirthDate());
        savedDto.setHospitalCode(saved.getHospitalCode());

        return savedDto;
    }



    public void deleteDoctorProfileByCode(String code) {
        doctorProfileDetailRepo.deleteById(code);
    }

}

