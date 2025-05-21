package com.Dtest.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "Department")
public class Department {

    @Id
    @JsonProperty("DEPARTMENT_CODE")
    private String departmentCode;

    @JsonProperty("DEPARTMENT_DESC")
    private String departmentDesc;

    @JsonProperty("IS_ACTIVE")
    private boolean isActive;

    @ManyToMany(mappedBy = "departments")
    private List<DoctorDetailsDesc> doctorDetailsDescs = new ArrayList<>();


}
