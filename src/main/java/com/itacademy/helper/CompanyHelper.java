package com.itacademy.helper;

import com.itacademy.api.companyservice.models.CompanyData;

public class CompanyHelper {
    public CompanyData companyWithMandatoryFields() {
        return CompanyData.builder()
                .id("6789")
                .name("Epam")
                .build();
    }

    public CompanyData companyWithoutMandatoryFields() {
        return CompanyData.builder()
                .id("7878")
                .build();
    }
    public CompanyData companyWithEmptyMandatoryFields() {
        return CompanyData.builder()
                .id("7878")
                .name("")
                .build();
    }
}
