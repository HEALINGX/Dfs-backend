package com.Dtest.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class DoctorProfileDetailDTO {

    @JsonProperty("CODE")
    private String code;

    @JsonProperty("USER_ID")
    private String userId;

    @JsonProperty("TELEPHONE")
    private String telephone;

    @JsonProperty("EMPLOYEE_ID")
    private String employeeId;

    @JsonProperty("LICENSE_ID")
    private String licenseId;

    @JsonProperty("NAME_ENG")
    private String nameEng;

    @JsonProperty("ACTIVE")
    private boolean active;

    @JsonProperty("UPDATE_DATE")
    private LocalDate updateDate;

    @JsonProperty("UPDATE_TIME")
    private LocalTime updateTime;

    @JsonProperty("NATION_ID")
    private String nationId;

    @JsonProperty("NAME_THAI")
    private String nameThai;

    @JsonProperty("BIRTH_DATE")
    private LocalDate birthDate;

    @JsonProperty("HOSPITAL_CODE")
    private String hospitalCode;

    @JsonProperty("doctorDetailsDescs")
    private List<DoctorDetailsDescDTO> doctorDetailsDescs;

}
