package com.Dtest.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "DoctorProfileDetail")
public class DoctorProfileDetail {

    @Id
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
    @Column(name = "UPDATE_DATE")
    private LocalDate updateDate;

    @JsonProperty("UPDATE_TIME")
    @Column(name = "UPDATE_TIME")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime updateTime;

    @JsonProperty("NATION_ID")
    private String nationId;

    @JsonProperty("NAME_THAI")
    private String nameThai;

    @JsonProperty("BIRTH_DATE")
    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @JsonProperty("HOSPITAL_CODE")
    private String hospitalCode;

    @PrePersist
    @PreUpdate
    public void setDefaultValues() {
        if (this.updateDate == null) {
            this.updateDate = LocalDate.now();
        }
        if (this.updateTime == null) {
            this.updateTime = LocalTime.now();
        }
    }

    @OneToMany(mappedBy = "doctorProfileDetail", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<DoctorDetailsDesc> doctorDetailsDescs = new ArrayList<>();


}
