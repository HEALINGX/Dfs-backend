package com.Dtest.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class DoctorDetailDescDTO {

    @JsonProperty("DOCTOR_CODE")
    private String doctorCode;

    @JsonProperty("HOSPITAL_CODE")
    private String hospitalCode;

    @JsonProperty("DESCRIPTION")
    private String description;

    @JsonProperty("RESIGN")
    private String resign;

    @JsonProperty("NAME_ENG")
    private String nameEng;

    @JsonProperty("NAME_THAI")
    private String nameThai;

    @JsonProperty("PERSON")
    private String person;

    @JsonProperty("ACTIVE")
    private boolean active;

    @JsonProperty("ADDRESS_NUMBER")
    private String addressNumber;

    @JsonProperty("DISTRICT")
    private String district;

    @JsonProperty("PROVINCE")
    private String province;

    @JsonProperty("POSTAL_CODE")
    private String postalCode;

    @JsonProperty("EMAIL")
    private String email;

    @JsonProperty("LICENSE_ID")
    private String licenseId;

    @JsonProperty("SALARY")
    private String salary;

    @JsonProperty("LICENCE_ISSUE_DATE")
    private LocalDate licenceIssueDate;

    @JsonProperty("START_WORKING_DATE")
    private LocalDate startWorkDate;

    @JsonProperty("DOCTOR_TYPE")
    private String doctorType;

    @JsonProperty("DOCTOR_GROUP")
    private String doctorGroup;

    @JsonProperty("DOCTOR_CATEGORY")
    private String doctorCategory;

    @JsonProperty("HOSPITAL_UNIT")
    private String hospitalUnit;

    @JsonProperty("SPECIALTY")
    private String specialty;

    @JsonProperty("SPECIALTY_DESC")
    private String specialtyDesc;

    @JsonProperty("PAYMENT_MODE")
    private String paymentMode;

    @JsonProperty("PAYMENT_REVENUE_CODE")
    private String paymentRevenueCode;

    @JsonProperty("ADVANCE_PAYMENT")
    private String advancePayment;

    @JsonProperty("TIME_TO_PAYMENT")
    private String timeToPayment;

    @JsonProperty("TAX_ID")
    private String taxId;

    @JsonProperty("PAT_TAX_BY")
    private String patTaxBy;

    @JsonProperty("INCLUDE_40_2_REVENUE_TO_CODE")
    private String include402Revenue;

    @JsonProperty("TAX_40_2_CALCULATION")
    private String tax402Calculation;

    @JsonProperty("INCLUDE_40_6_REVENUE_TO_CODE")
    private String include406Revenue;

    @JsonProperty("TAX_40_6_CALCULATION")
    private String tax406Calculation;

    @JsonProperty("DOCTOR_PROFILE_CODE")
    private String doctorProfileCode;

    @JsonProperty("FILES")
    private List<FileDTO> files;

    @JsonProperty("GUARANTEES")
    private List<GuaranteeDTO> guarantees;

    @JsonProperty("DEPARTMENTS")
    private List<DepartmentDTO> departments;

    @JsonProperty("NOTES")
    private List<NoteDTO> notes;
}
