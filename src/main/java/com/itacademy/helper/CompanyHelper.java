package com.itacademy.helper;

import com.itacademy.api.companyservice.models.CompanyData;

public class CompanyHelper {

    public static final String EMPTY_VALUE_FOR_COMPANY_DATA = "";
    private final String COMPANY_ID = "6789";
    private final String MANDATORY_COMPANY_NAME = "Epam";

    public CompanyData companyWithMandatoryFields() {
        return CompanyData.builder()
                .id(COMPANY_ID)
                .name(MANDATORY_COMPANY_NAME)
                .build();
    }

    public CompanyData companyWithoutMandatoryFields() {
        return CompanyData.builder()
                .id(COMPANY_ID)
                .build();
    }
    public CompanyData companyWithEmptyMandatoryFields() {
        return CompanyData.builder()
                .id(COMPANY_ID)
                .name(EMPTY_VALUE_FOR_COMPANY_DATA)
                .build();
    }
}
