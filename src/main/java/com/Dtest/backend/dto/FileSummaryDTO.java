package com.Dtest.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class FileSummaryDTO {

    @JsonProperty("FILE_SOURCE")
    private String fileSource;

    @JsonProperty("UPDATE_DATE")
    private LocalDate updateDate;

    @JsonProperty("UPDATE_TIME")
    private LocalTime updateTime;

    @JsonProperty("FILE_NAME")
    private String fileName;

}
