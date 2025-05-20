package com.Dtest.backend.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DepartmentSummaryDTO {

    @JsonProperty("DEPARTMENT_CODE")
    private String departmentCode;

    @JsonProperty("DEPARTMENT_DESC")
    private String departmentDesc;

    @JsonProperty("IS_ACTIVE")
    private boolean isActive;

}
