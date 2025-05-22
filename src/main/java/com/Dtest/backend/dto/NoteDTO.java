package com.Dtest.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class NoteDTO {

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
    private LocalDate updateDate;

    @JsonProperty("UPDATE_TIME")
    private LocalTime updateTime;

    @JsonProperty("DOCTOR_CODE")
    private String doctorCode;

}
