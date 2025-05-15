// DoctorProfileDetailService.java
package com.Dtest.backend.service;

import com.Dtest.backend.dto.DoctorProfileDetailDTO;
import com.Dtest.backend.mapper.DoctorProfileDetailMapper;
import com.Dtest.backend.model.DoctorProfileDetail;
import com.Dtest.backend.model.DoctorDetailsDesc;
import com.Dtest.backend.repository.DoctorDetailsDescRepo;
import com.Dtest.backend.repository.DoctorProfileDetailRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DoctorProfileDetailService {

    @Autowired
    private DoctorProfileDetailRepo doctorProfileDetailRepo;

    // คืน Entity (ใช้ภายใน service สำหรับ save/update)
    public Optional<DoctorProfileDetail> getDoctorProfileByCode(String code) {
        return doctorProfileDetailRepo.findByCode(code);
    }

    public DoctorProfileDetail updateDoctorProfileFromDTO(String code, DoctorProfileDetailDTO dto) {
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

        // อัพเดต doctorDetailsDescs
        if (dto.getDoctorDetailsDescs() != null) {
            // เคลียร์ของเก่า
            existing.getDoctorDetailsDescs().clear();

            // แปลง DTO เป็น entity และเชื่อมโยงกลับ
            List<DoctorDetailsDesc> details = dto.getDoctorDetailsDescs().stream().map(detailDTO -> {
                DoctorDetailsDesc detail = new DoctorDetailsDesc();
                detail.setDoctorCode(detailDTO.getDoctorCode());
                detail.setHospitalCode(detailDTO.getHospitalCode());
                detail.setDescription(detailDTO.getDescription());
                detail.setResign(detailDTO.getResign());
                detail.setNameEng(detailDTO.getNameEng());
                detail.setNameThai(detailDTO.getNameThai());
                detail.setPerson(detailDTO.getPerson());
                detail.setActive(detailDTO.isActive());
                detail.setAddressNumber(detailDTO.getAddressNumber());
                detail.setDistrict(detailDTO.getDistrict());
                detail.setProvince(detailDTO.getProvince());
                detail.setPostalCode(detailDTO.getPostalCode());
                detail.setEmail(detailDTO.getEmail());
                detail.setLicenseId(detailDTO.getLicenseId());
                detail.setSalary(detailDTO.getSalary());
                detail.setLicenceIssueDate(detailDTO.getLicenceIssueDate());
                detail.setStartWorkDate(detailDTO.getStartWorkDate());
                detail.setDoctorType(detailDTO.getDoctorType());
                detail.setDoctorGroup(detailDTO.getDoctorGroup());
                detail.setDoctorCategory(detailDTO.getDoctorCategory());
                detail.setHospitalUnit(detailDTO.getHospitalUnit());
                detail.setSpecialty(detailDTO.getSpecialty());
                detail.setSpecialtyDesc(detailDTO.getSpecialtyDesc());
                detail.setPaymentMode(detailDTO.getPaymentMode());
                detail.setPaymentRevenueCode(detailDTO.getPaymentRevenueCode());
                detail.setAdvancePayment(detailDTO.getAdvancePayment());
                detail.setTimeToPayment(detailDTO.getTimeToPayment());
                detail.setTaxId(detailDTO.getTaxId());
                detail.setPatTaxBy(detailDTO.getPatTaxBy());
                detail.setInclude402Revenue(detailDTO.getInclude402Revenue());
                detail.setTax402Calculation(detailDTO.getTax402Calculation());
                detail.setInclude406Revenue(detailDTO.getInclude406Revenue());
                detail.setTax406Calculation(detailDTO.getTax406Calculation());

                // เชื่อมโยงกลับ
                detail.setDoctorProfileDetail(existing);
                return detail;
            }).toList();

            existing.getDoctorDetailsDescs().addAll(details);
        }

        // บันทึกและรีเทิร์น entity พร้อมความสัมพันธ์ครบถ้วน
        DoctorProfileDetail saved = doctorProfileDetailRepo.save(existing);

        // (ถ้า fetch type เป็น LAZY อาจต้องโหลด doctorDetailsDescs เพิ่มเติมก่อน return)
        saved.getDoctorDetailsDescs().size(); // บังคับโหลด (ถ้าจำเป็น)

        return saved;
    }


    // คืน DTO (สำหรับ controller ส่ง response)
    public Optional<DoctorProfileDetailDTO> getDoctorProfileDTOByCode(String code) {
        return doctorProfileDetailRepo.findByCode(code)
                .map(DoctorProfileDetailMapper::toDTO);
    }


    public DoctorProfileDetail saveOrUpdateDoctorProfile(DoctorProfileDetail doctorProfileDetail) {
        return doctorProfileDetailRepo.save(doctorProfileDetail);
    }

    public void deleteDoctorProfileByCode(String code) {
        doctorProfileDetailRepo.deleteById(code);
    }

}

