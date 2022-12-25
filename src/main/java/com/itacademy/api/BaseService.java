package com.itacademy.api;

import com.itacademy.configuration.ConfigManager;
import com.itacademy.configuration.Configuration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseService {
    private final static Configuration configuration = ConfigManager.CONFIG;
    public final static RequestSpecification BASE_SPEC = given()
            .when()
            .contentType(ContentType.JSON)
            .baseUri(ConfigManager.CONFIG.baseApiUrl())
            .auth().preemptive().basic(configuration.username(), configuration.password())
            .log().all();

    protected Response checkResponse(Response response, int statusCode) {
        response.then().statusCode(statusCode);
        return response;
    }
}
