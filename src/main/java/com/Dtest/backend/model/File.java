package com.Dtest.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "FILE")
public class File {

    @Id
    @JsonProperty("ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("FILE_SOURCE")
    private String fileSource;

    @JsonProperty("UPDATE_DATE")
    @Column(name = "UPDATE_DATE")
    private LocalDate updateDate;

    @JsonProperty("UPDATE_TIME")
    @Column(name = "UPDATE_TIME")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime updateTime;

    @JsonProperty("FILE_NAME")
    private String fileName;

    @ManyToOne
    @JoinColumn(name = "doctor_code", referencedColumnName = "doctorCode")
    private DoctorDetailsDesc doctorDetailsDesc;

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

}
