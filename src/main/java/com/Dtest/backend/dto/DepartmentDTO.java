package com.Dtest.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DepartmentDTO {

    @JsonProperty("DEPARTMENT_CODE")
    private String departmentCode;

    @JsonProperty("DEPARTMENT_DESC")
    private String departmentDesc;

    @JsonProperty("IS_ACTIVE")
    private boolean isActive;

//    @JsonProperty("DOCTOR_CODE")
//    private List<String> doctorCode;
}
