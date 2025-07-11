package com.Dtest.backend.service;

import com.Dtest.backend.dto.DoctorDetailsDescDTO;
import com.Dtest.backend.dto.DoctorDetailsDescSummaryDTO;
import com.Dtest.backend.mapper.DoctorDescDepartmentMapper;
import com.Dtest.backend.mapper.DoctorDetailsDescMapper;
import com.Dtest.backend.model.Department;
import com.Dtest.backend.model.DoctorDetailsDesc;
import com.Dtest.backend.repository.DepartmentRepo;
import com.Dtest.backend.repository.DoctorDetailsDescRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorDetailsDescService {

    @Autowired
    private DoctorDetailsDescRepo doctorDetailsDescRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    public DoctorDetailsDescDTO saveDoctorDetailsDesc(DoctorDetailsDescDTO dto) {
        // แปลง DTO → Entity ด้วย Mapper
        DoctorDetailsDesc entity = DoctorDescDepartmentMapper.dtoToEntity(dto);

        if (dto.getDepartmentCodes() != null && !dto.getDepartmentCodes().isEmpty()) {
            List<Department> departments = departmentRepo.findAllById(dto.getDepartmentCodes());
            entity.setDepartments(departments);
        }

        DoctorDetailsDesc saved = doctorDetailsDescRepo.save(entity);

        return DoctorDescDepartmentMapper.toDTO(saved);
    }


    // คืน DTO (สำหรับ controller ส่ง response)
    public Optional<DoctorDetailsDescSummaryDTO> getDoctorDetailsDescByCode(String doctorCode) {
        return doctorDetailsDescRepo.findById(doctorCode)
                .map(DoctorDetailsDescMapper::toDTO);
    }

    // Update ข้อมูลตาม doctorCode โดยใช้ DTO
    public DoctorDetailsDescDTO updateDoctorDetailsDesc(String doctorCode, DoctorDetailsDescDTO dto) {
        Optional<DoctorDetailsDesc> existingOpt = doctorDetailsDescRepo.findById(doctorCode);
        if (existingOpt.isEmpty()) {
            throw new RuntimeException("DoctorDetailsDesc not found");
        }
        DoctorDetailsDesc existing = existingOpt.get();

        DoctorDetailsDesc updatedEntity = DoctorDescDepartmentMapper.dtoToEntity(dto);

        existing.setHospitalCode(updatedEntity.getHospitalCode());
        existing.setDescription(updatedEntity.getDescription());
        existing.setResign(updatedEntity.getResign());
        existing.setNameEng(updatedEntity.getNameEng());
        existing.setNameThai(updatedEntity.getNameThai());
        existing.setPerson(updatedEntity.getPerson());
        existing.setActive(updatedEntity.isActive());
        existing.setAddressNumber(updatedEntity.getAddressNumber());
        existing.setDistrict(updatedEntity.getDistrict());
        existing.setProvince(updatedEntity.getProvince());
        existing.setPostalCode(updatedEntity.getPostalCode());
        existing.setEmail(updatedEntity.getEmail());
        existing.setLicenseId(updatedEntity.getLicenseId());
        existing.setSalary(updatedEntity.getSalary());
        existing.setLicenceIssueDate(updatedEntity.getLicenceIssueDate());
        existing.setStartWorkDate(updatedEntity.getStartWorkDate());
        existing.setDoctorType(updatedEntity.getDoctorType());
        existing.setDoctorGroup(updatedEntity.getDoctorGroup());
        existing.setDoctorCategory(updatedEntity.getDoctorCategory());
        existing.setHospitalUnit(updatedEntity.getHospitalUnit());
        existing.setSpecialty(updatedEntity.getSpecialty());
        existing.setSpecialtyDesc(updatedEntity.getSpecialtyDesc());
        existing.setPaymentMode(updatedEntity.getPaymentMode());
        existing.setPaymentRevenueCode(updatedEntity.getPaymentRevenueCode());
        existing.setAdvancePayment(updatedEntity.getAdvancePayment());
        existing.setTimeToPayment(updatedEntity.getTimeToPayment());
        existing.setTaxId(updatedEntity.getTaxId());
        existing.setPatTaxBy(updatedEntity.getPatTaxBy());
        existing.setInclude402Revenue(updatedEntity.getInclude402Revenue());
        existing.setTax402Calculation(updatedEntity.getTax402Calculation());
        existing.setInclude406Revenue(updatedEntity.getInclude406Revenue());
        existing.setTax406Calculation(updatedEntity.getTax406Calculation());


        if (dto.getDepartmentCodes() != null && !dto.getDepartmentCodes().isEmpty()) {
            List<Department> departments = departmentRepo.findAllById(dto.getDepartmentCodes());
            existing.setDepartments(departments);
        }

        DoctorDetailsDesc saved = doctorDetailsDescRepo.save(existing);

        return DoctorDescDepartmentMapper.toDTO(saved);
    }

    public void deleteDoctorDetailsDescByCode(String doctorCode) {
        doctorDetailsDescRepo.deleteById(doctorCode);
    }

    // แปลง DTO → Entity
    private DoctorDetailsDesc dtoToEntity(DoctorDetailsDescSummaryDTO dto) {
        DoctorDetailsDesc entity = new DoctorDetailsDesc();
        entity.setDoctorCode(dto.getDoctorCode());
        entity.setHospitalCode(dto.getHospitalCode());
        entity.setDescription(dto.getDescription());
        entity.setResign(dto.getResign());
        entity.setNameEng(dto.getNameEng());
        entity.setNameThai(dto.getNameThai());
        entity.setPerson(dto.getPerson());
        entity.setActive(dto.isActive());
        entity.setAddressNumber(dto.getAddressNumber());
        entity.setDistrict(dto.getDistrict());
        entity.setProvince(dto.getProvince());
        entity.setPostalCode(dto.getPostalCode());
        entity.setEmail(dto.getEmail());
        entity.setLicenseId(dto.getLicenseId());
        entity.setSalary(dto.getSalary());
        entity.setLicenceIssueDate(dto.getLicenceIssueDate());
        entity.setStartWorkDate(dto.getStartWorkDate());
        entity.setDoctorType(dto.getDoctorType());
        entity.setDoctorGroup(dto.getDoctorGroup());
        entity.setDoctorCategory(dto.getDoctorCategory());
        entity.setHospitalUnit(dto.getHospitalUnit());
        entity.setSpecialty(dto.getSpecialty());
        entity.setSpecialtyDesc(dto.getSpecialtyDesc());
        entity.setPaymentMode(dto.getPaymentMode());
        entity.setPaymentRevenueCode(dto.getPaymentRevenueCode());
        entity.setAdvancePayment(dto.getAdvancePayment());
        entity.setTimeToPayment(dto.getTimeToPayment());
        entity.setTaxId(dto.getTaxId());
        entity.setPatTaxBy(dto.getPatTaxBy());
        entity.setInclude402Revenue(dto.getInclude402Revenue());
        entity.setTax402Calculation(dto.getTax402Calculation());
        entity.setInclude406Revenue(dto.getInclude406Revenue());
        entity.setTax406Calculation(dto.getTax406Calculation());

        return entity;
    }

    // แปลง Entity → DTO
    private DoctorDetailsDescSummaryDTO entityToDto(DoctorDetailsDesc entity) {
        DoctorDetailsDescSummaryDTO dto = new DoctorDetailsDescSummaryDTO();
        dto.setDoctorCode(entity.getDoctorCode());
        dto.setHospitalCode(entity.getHospitalCode());
        dto.setDescription(entity.getDescription());
        dto.setResign(entity.getResign());
        dto.setNameEng(entity.getNameEng());
        dto.setNameThai(entity.getNameThai());
        dto.setPerson(entity.getPerson());
        dto.setActive(entity.isActive());
        dto.setAddressNumber(entity.getAddressNumber());
        dto.setDistrict(entity.getDistrict());
        dto.setProvince(entity.getProvince());
        dto.setPostalCode(entity.getPostalCode());
        dto.setEmail(entity.getEmail());
        dto.setLicenseId(entity.getLicenseId());
        dto.setSalary(entity.getSalary());
        dto.setLicenceIssueDate(entity.getLicenceIssueDate());
        dto.setStartWorkDate(entity.getStartWorkDate());
        dto.setDoctorType(entity.getDoctorType());
        dto.setDoctorGroup(entity.getDoctorGroup());
        dto.setDoctorCategory(entity.getDoctorCategory());
        dto.setHospitalUnit(entity.getHospitalUnit());
        dto.setSpecialty(entity.getSpecialty());
        dto.setSpecialtyDesc(entity.getSpecialtyDesc());
        dto.setPaymentMode(entity.getPaymentMode());
        dto.setPaymentRevenueCode(entity.getPaymentRevenueCode());
        dto.setAdvancePayment(entity.getAdvancePayment());
        dto.setTimeToPayment(entity.getTimeToPayment());
        dto.setTaxId(entity.getTaxId());
        dto.setPatTaxBy(entity.getPatTaxBy());
        dto.setInclude402Revenue(entity.getInclude402Revenue());
        dto.setTax402Calculation(entity.getTax402Calculation());
        dto.setInclude406Revenue(entity.getInclude406Revenue());
        dto.setTax406Calculation(entity.getTax406Calculation());

        return dto;
    }

}

