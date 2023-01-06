package api.companies;

import com.itacademy.api.companyservice.models.CompanyData;
import com.itacademy.api.companyservice.models.CompanyService;
import com.itacademy.helper.CompanyHelper;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

public class CompanyTest {
    private final static CompanyService companyService = new CompanyService();
    private final static CompanyHelper companyHelper = new CompanyHelper();
    public static final String DEFUNCT_COMPANY_ID = "000200002";

    @Test
    public void getAllCompaniesList() {
        List<CompanyData> allCompanies = companyService.getCompanies();
        Assertions.assertThat(allCompanies).extracting(CompanyData::getName).allMatch(Objects::nonNull);
    }
    @Test
    public void createCompany() {
        CompanyData companyData = companyHelper.companyWithMandatoryFields();
        CompanyData createdCompany = companyService.createCompany(companyData);
        Assertions.assertThat(createdCompany).usingRecursiveComparison().isEqualTo(companyData);
    }
    @Test
    public void createCompanyWithMissingCompanyName() {
        CompanyData companyData = companyHelper.companyWithoutMandatoryFields();
        Response response = companyService.createCompany(companyData, 400);
        String error = response.then().extract().body().jsonPath().getString("error");
        Assertions.assertThat(error).isEqualTo("Bad Request. The field \"name\" should be present in the body");

    }
    @Test
    public void createCompanyWithEmptyCompanyName() {
        CompanyData companyData = companyHelper.companyWithEmptyMandatoryFields();
        Response response = companyService.createCompany(companyData, 400);
        String error = response.then().extract().body().jsonPath().getString("error");
        Assertions.assertThat(error).isEqualTo("Bad Request. The field \"name\" cannot be empty");
    }
    @Test
    public void deleteCompany() {
        CompanyData companyData = companyHelper.companyWithMandatoryFields();
        CompanyData createdCompany = companyService.createCompany(companyData);
        Response response = companyService.deleteCompany(createdCompany.getId(), 200);
        assertThatJson(response.body().asString()).isObject().isEmpty();

    }
    @Test
    public void deleteCompanyWithDefunctId() {
        Response response = companyService.deleteCompany(DEFUNCT_COMPANY_ID, 404);
        assertThatJson(response.body().asString()).isObject().isEmpty();

    }
}
