package com.Dtest.backend.mapper;

import com.Dtest.backend.dto.DoctorProfileDescDTO;
import com.Dtest.backend.dto.DoctorProfileDetailSummaryDTO;
import com.Dtest.backend.model.DoctorDetailsDesc;
import com.Dtest.backend.model.DoctorProfileDetail;

import java.util.List;
import java.util.stream.Collectors;

public class DoctorProfileDetailMapper {

    public static DoctorProfileDetailSummaryDTO toDTO(DoctorProfileDetail entity) {
        DoctorProfileDetailSummaryDTO dto = new DoctorProfileDetailSummaryDTO();
        dto.setCode(entity.getCode());
        dto.setUserId(entity.getUserId());
        dto.setTelephone(entity.getTelephone());
        dto.setEmployeeId(entity.getEmployeeId());
        dto.setLicenseId(entity.getLicenseId());
        dto.setNameEng(entity.getNameEng());
        dto.setActive(entity.isActive());
        dto.setUpdateDate(entity.getUpdateDate());
        dto.setUpdateTime(entity.getUpdateTime());
        dto.setNationId(entity.getNationId());
        dto.setNameThai(entity.getNameThai());
        dto.setBirthDate(entity.getBirthDate());
        dto.setHospitalCode(entity.getHospitalCode());

        List<DoctorProfileDescDTO> details = entity.getDoctorDetailsDescs().stream()
                .map(DoctorProfileDetailMapper::toDTO)
                .collect(Collectors.toList());

        dto.setDoctorDetailsDescs(details);

        return dto;
    }

    public static DoctorProfileDescDTO toDTO(DoctorDetailsDesc entity) {
        DoctorProfileDescDTO dto = new DoctorProfileDescDTO();
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
