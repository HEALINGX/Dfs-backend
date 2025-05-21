package com.Dtest.backend.mapper;

import com.Dtest.backend.dto.DoctorDetailsDescDTO;
import com.Dtest.backend.model.DoctorDetailsDesc;
import com.Dtest.backend.model.Department;
import com.Dtest.backend.model.DoctorProfileDetail;

import java.util.List;
import java.util.stream.Collectors;

public class DoctorDescDepartmentMapper {

    // แปลง Entity → DTO
    public static DoctorDetailsDescDTO toDTO(DoctorDetailsDesc entity) {
        if (entity == null) {
            return null;
        }

        DoctorDetailsDescDTO dto = new DoctorDetailsDescDTO();
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

        // แปลง departments (ManyToMany) เป็น List<String> ของ departmentCode
        if (entity.getDepartments() != null && !entity.getDepartments().isEmpty()) {
            List<String> departmentCodes = entity.getDepartments().stream()
                    .map(Department::getDepartmentCode)
                    .collect(Collectors.toList());
            dto.setDepartmentCodes(departmentCodes);
        }

        if (entity.getDoctorProfileDetail() != null) {
            dto.setDoctorProfileCode(entity.getDoctorProfileDetail().getCode());
        }

        return dto;
    }

    // แปลง DTO → Entity
    public static DoctorDetailsDesc dtoToEntity(DoctorDetailsDescDTO dto) {
        if (dto == null) {
            return null;
        }

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

        if (dto.getDoctorProfileCode() != null) {
            DoctorProfileDetail profile = new DoctorProfileDetail();
            profile.setCode(dto.getDoctorProfileCode());
            entity.setDoctorProfileDetail(profile);
        }

        return entity;
    }
}
