package com.itacademy.helper;

import com.itacademy.api.companyservice.models.CompanyData;

public class CompanyHelper {

    private final String MANDATORY_FIELD_NAME_EPAM = "Epam";
    public CompanyData companyWithMandatoryFields() {
        return CompanyData.builder()
                .id("6789") // эти вот Magic Values and Numbers лучше вынести в отдельные переменные класса. здесь и далее.
                .name(MANDATORY_FIELD_NAME_EPAM) // так типа понятней что это за значение передается
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
