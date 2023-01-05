package com.itacademy.helper;

import com.itacademy.api.companyservice.models.CompanyData;

public class CompanyHelper {

    private final String COMPANY_ID = "6789";
    private final String MANDATORY_FIELD_NAME_EPAM = "Epam";
    public CompanyData companyWithMandatoryFields() {
        return CompanyData.builder()
                .id(COMPANY_ID)
                .name(MANDATORY_FIELD_NAME_EPAM)
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
                .name("")
                .build();
    }
}
