package com.automation.tests;

import com.automation.annotations.FrameworkAnnotation;
import com.automation.constants.FrameworkConstants;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.automation.enums.Authors.USER_2;
import static com.automation.enums.CategoryType.SMOKE;
import static com.automation.models.builders.RequestBuilder.createRequestSpecification;
import static com.automation.reports.ExtentLogger.logRequest;
import static com.automation.reports.ExtentLogger.logResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static org.evomaster.client.java.controller.contentMatchers.NumberMatcher.numberMatches;
import static org.hamcrest.Matchers.containsString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@WireMockTest(httpPort = 3002)
public final class MockedTest {
  private static final String JSON_CONTENT = "{\n" +
          "  \"id\": 9090,\n" +
          "  \"title\": \"Activity 9090\",\n" +
          "  \"dueDate\": \"2024-02-02T06:18:42.844Z\",\n" +
          "  \"completed\": true\n" +
          "}";
  private static final String baseUrlOfThirdPartyAPI = "http://localhost:3002";
  private static final String baseUrlOfSut = "https://fakerestapi.azurewebsites.net/api/v1";
  @Test
  public void mockingAPI(WireMockRuntimeInfo wmRuntimeInfo) {
    stubFor(get("/third-party-api")
            .willReturn(aResponse().withBody(JSON_CONTENT).withStatus(201)));

    System.out.println(wmRuntimeInfo.getHttpBaseUrl());
    // Instance DSL can be obtained from the runtime info parameter
    ValidatableResponse res_0 = given()
            .get(baseUrlOfThirdPartyAPI + "/third-party-api")
            .then()
            .statusCode(201);

    String data = res_0.extract().response().body().prettyPrint();
    System.out.println("result of api " + data);
    // Info such as port numbers is also available
    given()
            .body(data)
            .post(baseUrlOfSut + "/Activities")
            .then()
            .statusCode(415);
  }
}
