package com.Dtest.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class GuaranteeSummaryDTO {

    @JsonProperty("GUARANTEE_TYPE_CODE")
    private String guaranteeTypeCode;

    @JsonProperty("IS_LUMP_SUM")
    private String isLumpSum;

    @JsonProperty("GUARANTEE_METHOD")
    private String guaranteeMethod;

    @JsonProperty("CONTRACT_START_DATE")
    private LocalDate contractStartDate;

    @JsonProperty("CONTRACT_EXPIRE_DATE")
    private LocalDate contractExpireDate;

    @JsonProperty("GUARANTEE_AMOUNT_HOUR")
    private String guaranteeAmountHour;

    @JsonProperty("EXTRA_HOUR")
    private String extraHour;

    @JsonProperty("IN_GUARANTEE_ALLOCATE")
    private String inGuaranteeAllocate;

    @JsonProperty("OVER_GUARANTEE_ALLOCATE")
    private String overGuaranteeAllocate;

    @JsonProperty("INCLUDE_REVENUE_TO_DR")
    private String includeRevenueToDr;

    @JsonProperty("REVENUE_FOR_GUARANTEE")
    private String revenueForGuarantee;

    @JsonProperty("GUARANTEE_BY_DAY")
    private String guaranteeByDay;

    @JsonProperty("ABSORD_EXTRA_TAX_TYPE")
    private String absordExtraTaxType;

    @JsonProperty("GUARANTEE_CATEGORY")
    private String guaranteeCategory;

    @JsonProperty("EARLY_TIME")
    private String earlyTime;

    @JsonProperty("LATE_TIME")
    private String lateTime;

    @JsonProperty("ACTIVE")
    private boolean active;

}
