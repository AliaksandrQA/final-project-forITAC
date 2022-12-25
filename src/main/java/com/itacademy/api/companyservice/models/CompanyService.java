package com.itacademy.api.companyservice.models;

import com.itacademy.api.BaseService;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CompanyService extends BaseService {
    private static final String COMPANY_PATH = "/companies";
    private static final String COMPANY_PATH_WITH_ID = "/companies/{id}";

    private RequestSpecification getCompanySpec() {
        return given(BASE_SPEC)
                .basePath(COMPANY_PATH);
    }

    private RequestSpecification getCompanyWithIdSpec(String id) {
        return given(BASE_SPEC)
                .basePath(COMPANY_PATH_WITH_ID)
                .pathParam("id", id);
    }

    public Response getCompany(String id, int statusCode) {
        Response response = getCompanyWithIdSpec(id).get();
        return checkResponse(response, statusCode);

    }

    public CompanyData getCompany(String id) {
        return getCompany(id, 200).as(CompanyData.class);

    }

    public Response getCompanies(int statusCode) {
        Response response = getCompanySpec().get();
        return checkResponse(response, statusCode);
    }

    public List<CompanyData> getCompanies() {
        return getCompanies(200).jsonPath().getList(".", CompanyData.class);
    }

    public Response createCompany(CompanyData body, int statusCode) {
        Response response = getCompanySpec().body(body).post();
        return checkResponse(response, statusCode);

    }

    public CompanyData createCompany(CompanyData body) {
        return createCompany(body, 201).as(CompanyData.class);

    }

    public Response updateCompany(String companyId, CompanyData body, int statusCode) {
        Response response = getCompanyWithIdSpec(companyId).body(body).put();
        return checkResponse(response, statusCode);
    }

    public CompanyData updateCompany(String companyId, CompanyData body) {

        return updateCompany(companyId, body, 200).as(CompanyData.class);
    }

    public Response deleteCompany(String companyId, int statusCode) {
        Response response = getCompanyWithIdSpec(companyId).delete();
        return checkResponse(response, statusCode);
    }
}
