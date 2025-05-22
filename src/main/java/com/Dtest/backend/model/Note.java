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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "NOTE")
public class Note {

    @Id
    @JsonProperty("ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("USER_ID")
    private String userId;

    @JsonProperty("NOTE_SUBJECT")
    private String noteSubject;

    @JsonProperty("NOTE_CONTENT")
    private String noteContent;

    @JsonProperty("HBN_CODE")
    private String hbnCode;

    @JsonProperty("ACTIVE")
    private boolean active;

    @JsonProperty("UPDATE_DATE")
    @Column(name = "UPDATE_DATE")
    private LocalDate updateDate;

    @JsonProperty("UPDATE_TIME")
    @Column(name = "UPDATE_TIME")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime updateTime;

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
