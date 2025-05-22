package com.Dtest.backend.mapper;

import com.Dtest.backend.dto.*;
import com.Dtest.backend.model.*;

import java.util.stream.Collectors;

public class DoctorDetailsDescMapper {

    public static DoctorDetailsDescSummaryDTO toDTO(DoctorDetailsDesc entity) {
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

        if (entity.getDoctorProfileDetail() != null) {
            dto.setDoctorProfileCode(entity.getDoctorProfileDetail().getCode());
        }

        // Mapping lists of related entities to their DTOs
        dto.setFiles(entity.getFiles().stream()
                .map(DoctorDetailsDescMapper::fileToDTO)
                .collect(Collectors.toList()));

        dto.setGuarantees(entity.getGuarantees().stream()
                .map(DoctorDetailsDescMapper::guaranteeToDTO)
                .collect(Collectors.toList()));

        dto.setDepartments(entity.getDepartments().stream()
                .map(DoctorDetailsDescMapper::departmentToDTO)
                .collect(Collectors.toList()));

        dto.setNotes(entity.getNotes().stream()
                .map(DoctorDetailsDescMapper::noteToDTO)
                .collect(Collectors.toList()));

        return dto;
    }

    public static DepartmentSummaryDTO departmentToDTO(Department entity) {
        DepartmentSummaryDTO dto = new DepartmentSummaryDTO();
        dto.setDepartmentCode(entity.getDepartmentCode());
        dto.setDepartmentDesc(entity.getDepartmentDesc());
        dto.setActive(entity.isActive());
        return dto;
    }

    public static FileSummaryDTO fileToDTO(File entity) {
        FileSummaryDTO dto = new FileSummaryDTO();
        dto.setFileSource(entity.getFileSource());
        dto.setUpdateDate(entity.getUpdateDate());
        dto.setUpdateTime(entity.getUpdateTime());
        dto.setFileName(entity.getFileName());
        return dto;
    }

    public static GuaranteeSummaryDTO guaranteeToDTO(Guarantee entity) {
        GuaranteeSummaryDTO dto = new GuaranteeSummaryDTO();
        dto.setGuaranteeTypeCode(entity.getGuaranteeTypeCode());
        dto.setIsLumpSum(entity.getIsLumpSum());
        dto.setGuaranteeMethod(entity.getGuaranteeMethod());
        dto.setContractStartDate(entity.getContractStartDate());
        dto.setContractExpireDate(entity.getContractExpireDate());
        dto.setGuaranteeAmountHour(entity.getGuaranteeAmountHour());
        dto.setExtraHour(entity.getExtraHour());
        dto.setInGuaranteeAllocate(entity.getInGuaranteeAllocate());
        dto.setOverGuaranteeAllocate(entity.getOverGuaranteeAllocate());
        dto.setIncludeRevenueToDr(entity.getIncludeRevenueToDr());
        dto.setRevenueForGuarantee(entity.getRevenueForGuarantee());
        dto.setGuaranteeByDay(entity.getGuaranteeByDay());
        dto.setAbsordExtraTaxType(entity.getAbsordExtraTaxType());
        dto.setGuaranteeCategory(entity.getGuaranteeCategory());
        dto.setEarlyTime(entity.getEarlyTime());
        dto.setLateTime(entity.getLateTime());
        dto.setActive(entity.isActive());
        return dto;
    }

    public static NoteSummaryDTO noteToDTO(Note entity) {
        NoteSummaryDTO dto = new NoteSummaryDTO();
        dto.setUserId(entity.getUserId());
        dto.setNoteSubject(entity.getNoteSubject());
        dto.setNoteContent(entity.getNoteContent());
        dto.setHbnCode(entity.getHbnCode());
        dto.setActive(entity.isActive());
        dto.setUpdateDate(entity.getUpdateDate());
        dto.setUpdateTime(entity.getUpdateTime());
        return dto;
    }

    public static DoctorDetailsDesc dtoToEntity(DoctorDetailsDescSummaryDTO dto) {
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

        // เชื่อมโยง DoctorProfileDetail ผ่าน FK (ถ้ามี)
        if (dto.getDoctorProfileCode() != null) {
            DoctorProfileDetail profile = new DoctorProfileDetail();
            profile.setCode(dto.getDoctorProfileCode());
            entity.setDoctorProfileDetail(profile);
        }

        return entity;
    }

}
