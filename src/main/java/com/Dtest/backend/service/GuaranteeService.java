package com.Dtest.backend.service;

import com.Dtest.backend.dto.GuaranteeDTO;
import com.Dtest.backend.model.Guarantee;
import com.Dtest.backend.model.DoctorDetailsDesc;
import com.Dtest.backend.repository.GuaranteeRepo;
import com.Dtest.backend.repository.DoctorDetailsDescRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuaranteeService {

    @Autowired
    private GuaranteeRepo guaranteeRepo;

    @Autowired
    private DoctorDetailsDescRepo doctorDetailsDescRepo;

    // แปลง DTO → Entity
    private void updateEntityFromDto(Guarantee entity, GuaranteeDTO dto) {
        entity.setGuaranteeTypeCode(dto.getGuaranteeTypeCode());
        entity.setIsLumpSum(dto.getIsLumpSum());
        entity.setGuaranteeMethod(dto.getGuaranteeMethod());
        entity.setContractStartDate(dto.getContractStartDate());
        entity.setContractExpireDate(dto.getContractExpireDate());
        entity.setGuaranteeAmountHour(dto.getGuaranteeAmountHour());
        entity.setExtraHour(dto.getExtraHour());
        entity.setInGuaranteeAllocate(dto.getInGuaranteeAllocate());
        entity.setOverGuaranteeAllocate(dto.getOverGuaranteeAllocate());
        entity.setIncludeRevenueToDr(dto.getIncludeRevenueToDr());
        entity.setRevenueForGuarantee(dto.getRevenueForGuarantee());
        entity.setGuaranteeByDay(dto.getGuaranteeByDay());
        entity.setAbsordExtraTaxType(dto.getAbsordExtraTaxType());
        entity.setGuaranteeCategory(dto.getGuaranteeCategory());
        entity.setEarlyTime(dto.getEarlyTime());
        entity.setLateTime(dto.getLateTime());
        entity.setActive(dto.isActive());

        // ตั้ง FK doctorDetailsDesc
        if (dto.getDoctorCode() != null) {
            DoctorDetailsDesc doctorDetailsDesc = doctorDetailsDescRepo.findById(dto.getDoctorCode())
                    .orElseThrow(() -> new RuntimeException("DoctorDetailsDesc not found"));
            entity.setDoctorDetailsDesc(doctorDetailsDesc);
        } else {
            entity.setDoctorDetailsDesc(null);
        }
    }

    // แปลง Entity → DTO
    private GuaranteeDTO entityToDto(Guarantee entity) {
        GuaranteeDTO dto = new GuaranteeDTO();
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

        if (entity.getDoctorDetailsDesc() != null) {
            dto.setDoctorCode(entity.getDoctorDetailsDesc().getDoctorCode());
        }

        return dto;
    }

    // Create
    public GuaranteeDTO createGuarantee(GuaranteeDTO dto) {
        Guarantee entity = new Guarantee();
        updateEntityFromDto(entity, dto);
        Guarantee saved = guaranteeRepo.save(entity);
        return entityToDto(saved);
    }

    // Read
    public Optional<GuaranteeDTO> getGuaranteeById(String guaranteeTypeCode) {
        return guaranteeRepo.findById(guaranteeTypeCode)
                .map(this::entityToDto);
    }

    // Update
    public GuaranteeDTO updateGuarantee(String guaranteeTypeCode, GuaranteeDTO dto) {
        Guarantee existing = guaranteeRepo.findById(guaranteeTypeCode)
                .orElseThrow(() -> new RuntimeException("Guarantee not found"));
        updateEntityFromDto(existing, dto);
        Guarantee saved = guaranteeRepo.save(existing);
        return entityToDto(saved);
    }

    // Delete
    public void deleteGuarantee(String guaranteeTypeCode) {
        guaranteeRepo.deleteById(guaranteeTypeCode);
    }
}
