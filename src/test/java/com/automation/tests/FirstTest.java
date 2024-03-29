package com.automation.tests;

import  org.junit.jupiter.api.AfterAll;
import  org.junit.jupiter.api.BeforeAll;
import  org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test;
import  org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import  java.util.Map;
import  java.util.List;
import static org.evomaster.client.java.controller.api.EMTestUtils.*;
import  org.evomaster.client.java.controller.SutHandler;
import  io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import  io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;
import  io.restassured.config.JsonConfig;
import  io.restassured.path.json.config.JsonPathConfig;
import static io.restassured.config.RedirectConfig.redirectConfig;
import static org.evomaster.client.java.controller.contentMatchers.NumberMatcher.*;
import static org.evomaster.client.java.controller.contentMatchers.StringMatcher.*;
import static org.evomaster.client.java.controller.contentMatchers.SubStringMatcher.*;
import static org.evomaster.client.java.controller.expect.ExpectationHandler.expectationHandler;
import  org.evomaster.client.java.controller.expect.ExpectationHandler;
import  io.restassured.path.json.JsonPath;
import  java.util.Arrays;




/**
 * This file was automatically generated by EvoMaster on 2024-02-16T11:15:24.740410+05:30[Asia/Kolkata]
 * <br>
 * The generated test suite contains 20 tests
 * <br>
 * Covered targets: 36
 * <br>
 * Used time: 0h 1m 42s
 * <br>
 * Needed budget for current results: 100%
 * <br>
 *
 */
public class FirstTest {


  private static String baseUrlOfSut = "https://petstore.swagger.io";
  /** [ems] - expectations master switch - is the variable that activates/deactivates expectations individual test cases
   * by default, expectations are turned off. The variable needs to be set to [true] to enable expectations
   */
  private static boolean ems = false;
  /**
   * sco - supported code oracle - checking that the response status code is among those supported according to the schema
   */
  private static boolean sco = false;
  /**
   * rso - response structure oracle - checking that the response objects match the responses defined in the schema
   */
  private static boolean rso = false;


  @BeforeAll
  public static void initClass() {
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    RestAssured.useRelaxedHTTPSValidation();
    RestAssured.urlEncodingEnabled = false;
    RestAssured.config = RestAssured.config()
            .jsonConfig(JsonConfig.jsonConfig().numberReturnType(JsonPathConfig.NumberReturnType.DOUBLE))
            .redirect(redirectConfig().followRedirects(false));
  }








  @Test @Timeout(60)
  public void test_0() throws Exception {

    given().accept("application/json")
            .get(baseUrlOfSut + "/v2/pet/123")
            .then()
            .statusCode(200)
            .assertThat()
            .contentType("application/json")
            .body("'category'.'name'", containsString("string"))
            .body("'name'", containsString("doggie"))
            .body("'photoUrls'.size()", equalTo(1))
            .body("'photoUrls'", hasItems("string"))
            .body("'tags'.size()", equalTo(1))
            .body("'tags'[0].'name'", containsString("string"))
            .body("'status'", containsString("available"));

  }


  @Test @Timeout(60)
  public void test_1() throws Exception {

    given().accept("*/*")
            .contentType("application/json")
            .body(" [ " +
                    " { " +
                    " \"id\": 248, " +
                    " \"username\": \"_EM_1_XYZ_\", " +
                    " \"firstName\": \"_EM_2_XYZ_\", " +
                    " \"lastName\": \"_EM_3_XYZ_\", " +
                    " \"email\": \"_EM_4_XYZ_\", " +
                    " \"password\": \"wcetxmogdyf\", " +
                    " \"userStatus\": 164 " +
                    " } " +
                    " ] ")
            .post(baseUrlOfSut + "/v2/user/createWithList")
            .then()
            .statusCode(200)
            .assertThat()
            .contentType("application/json")
            .body("'code'", numberMatches(200.0))
            .body("'type'", containsString("unknown"))
            .body("'message'", containsString("ok"));

  }


  @Test @Timeout(60)
  public void test_2() throws Exception {

    given().accept("application/json")
            .get(baseUrlOfSut + "/v2/pet/findByStatus?status=")
            .then()
            .statusCode(200)
            .assertThat()
            .contentType("application/json")
            .body("size()", equalTo(0));

  }


  @Test @Timeout(60)
  public void test_3() throws Exception {

    given().accept("application/json")
            .get(baseUrlOfSut + "/v2/user/login?" +
                    "username=_EM_17_XYZ_&" +
                    "password=jBkO4JzkszA1Eht")
            .then()
            .statusCode(200)
            .assertThat()
            .contentType("application/json")
            .body("'code'", numberMatches(200.0))
            .body("'type'", containsString("unknown"));

  }


  @Test @Timeout(60)
  public void test_4() throws Exception {

    given().accept("application/json")
            .contentType("application/json")
            .body(" { " +
                    " \"shipDate\": \"1967-04-25T04:56:21\" " +
                    " } ")
            .post(baseUrlOfSut + "/v2/store/order")
            .then()
            .statusCode(200)
            .assertThat()
            .contentType("application/json")
            .body("'petId'", numberMatches(0.0))
            .body("'quantity'", numberMatches(0.0))
            .body("'shipDate'", containsString("1967-04-25T04:56:21.000+0000"))
            .body("'complete'", equalTo(false));

  }


  @Test @Timeout(60)
  public void test_5() throws Exception {

    given().accept("*/*")
            .contentType("application/json")
            .body(" [ " +
                    " { " +
                    " \"id\": 86, " +
                    " \"lastName\": \"3Bwp5Ld\", " +
                    " \"phone\": \"nYmwunA\", " +
                    " \"userStatus\": 255 " +
                    " }, " +
                    " { " +
                    " \"username\": \"SrO2XO0XdIM\", " +
                    " \"lastName\": \"jkZkOMuE4MyoI\", " +
                    " \"userStatus\": 38 " +
                    " }, " +
                    " { " +
                    " \"id\": 902, " +
                    " \"firstName\": \"lIj4F3p_I9\", " +
                    " \"phone\": \"ZMcm1UUDC2YtTZ\", " +
                    " \"userStatus\": 803 " +
                    " } " +
                    " ] ")
            .post(baseUrlOfSut + "/v2/user/createWithArray")
            .then()
            .statusCode(200)
            .assertThat()
            .contentType("application/json")
            .body("'code'", numberMatches(200.0))
            .body("'type'", containsString("unknown"))
            .body("'message'", containsString("ok"));

  }


  @Test @Timeout(60)
  public void test_6() throws Exception {
    ExpectationHandler expectationHandler = expectationHandler();

    ValidatableResponse res_0 = given().accept("application/json")
            .get(baseUrlOfSut + "/v2/store/inventory")
            .then()
            .statusCode(200)
            .assertThat()
            .contentType("application/json")
            .body("'sold'", numberMatches(8.0))
            .body("'Vigente'", numberMatches(1.0))
            .body("'string'", numberMatches(727.0))
            .body("'pending'", numberMatches(3.0))
            .body("'available'", numberMatches(219.0))
            .body("'Available'", numberMatches(8.0));

    expectationHandler.expect(ems);
  }


  @Test @Timeout(60)
  public void test_7() throws Exception {
    ExpectationHandler expectationHandler = expectationHandler();

    ValidatableResponse res_0 = given().accept("*/*")
            .contentType("application/json")
            .body(" { " +
                    " \"id\": -7636790768111536173, " +
                    " \"username\": \"kL6D1\", " +
                    " \"firstName\": \"Bn\", " +
                    " \"lastName\": \"p7EoXtp9dC5EO\", " +
                    " \"email\": \"Bvc9\", " +
                    " \"userStatus\": 227 " +
                    " } ")
            .put(baseUrlOfSut + "/v2/user/kL6D1")
            .then()
            .statusCode(200)
            .assertThat()
            .contentType("application/json")
            .body("'code'", numberMatches(200.0))
            .body("'type'", containsString("unknown"))
            .body("'message'", containsString("9223372036854775807"));

    expectationHandler.expect(ems)
            .that(sco, Arrays.asList(400, 404).contains(res_0.extract().statusCode()));
  }


  @Test @Timeout(60)
  public void test_8() throws Exception {
    ExpectationHandler expectationHandler = expectationHandler();

    ValidatableResponse res_0 = given().accept("*/*")
            .contentType("application/json")
            .body(" { " +
                    " \"id\": 245, " +
                    " \"name\": \"_EM_7_XYZ_\", " +
                    " \"photoUrls\": [ " +
                    " \"VwD\", " +
                    " \"_EM_8_XYZ_\", " +
                    " \"_EM_9_XYZ_\", " +
                    " \"_EM_10_XYZ_\" " +
                    " ] " +
                    " } ")
            .post(baseUrlOfSut + "/v2/pet")
            .then()
            .statusCode(200)
            .assertThat()
            .contentType("application/json")
            .body("'name'", containsString("_EM_7_XYZ_"))
            .body("'photoUrls'.size()", equalTo(4))
            .body("'photoUrls'", hasItems("VwD", "_EM_8_XYZ_", "_EM_9_XYZ_", "_EM_10_XYZ_"))
            .body("'tags'.size()", equalTo(0));

    expectationHandler.expect(ems)
            .that(sco, Arrays.asList(405).contains(res_0.extract().statusCode()));
  }


  @Test @Timeout(60)
  public void test_9() throws Exception {
    ExpectationHandler expectationHandler = expectationHandler();

    ValidatableResponse res_0 = given().accept("application/json")
            .get(baseUrlOfSut + "/v2/pet/findByTags?tags=")
            .then()
            .statusCode(200)
            .assertThat()
            .contentType("application/json")
            .body("size()", equalTo(1))
            .body("[0].'category'.'name'", containsString("Cat"))
            .body("[0].'name'", containsString("Josecito"))
            .body("[0].'tags'.size()", equalTo(1))
            .body("[0].'tags'[0].'name'", containsString(""))
            .body("[0].'status'", containsString("Vigente"));

    expectationHandler.expect(ems)
            .that(rso, ((Map) ((List) res_0.extract().response().jsonPath().getJsonObject("")).get(0)).keySet().containsAll(Arrays.asList("name", "photoUrls")));
  }


  @Test @Timeout(60)
  public void test_10() throws Exception {

    given().accept("*/*")
            .contentType("application/xml")
            .put(baseUrlOfSut + "/v2/pet")
            .then()
            .statusCode(400)
            .assertThat()
            .contentType("application/json")
            .body("'code'", numberMatches(400.0))
            .body("'type'", containsString("unknown"))
            .body("'message'", containsString("javax.xml.bind.UnmarshalException: unexpected element (uri:\"\", local:\"body\"). Expected elements are <{}Category>,<{}Pet>,<{}Tag>"));

  }


  @Test @Timeout(60)
  public void test_11() throws Exception {
    ExpectationHandler expectationHandler = expectationHandler();

    ValidatableResponse res_0 = given().accept("*/*")
            .contentType("application/xml")
            .post(baseUrlOfSut + "/v2/pet")
            .then()
            .statusCode(400)
            .assertThat()
            .contentType("application/json")
            .body("'code'", numberMatches(400.0))
            .body("'type'", containsString("unknown"))
            .body("'message'", containsString("javax.xml.bind.UnmarshalException: unexpected element (uri:\"\", local:\"body\"). Expected elements are <{}Category>,<{}Pet>,<{}Tag>"));

    expectationHandler.expect(ems)
            .that(sco, Arrays.asList(405).contains(res_0.extract().statusCode()));
  }


  @Test @Timeout(60)
  public void test_12() throws Exception {

    given().accept("application/json")
            .get(baseUrlOfSut + "/v2/user/_EM_0_XYZ_")
            .then()
            .statusCode(404)
            .assertThat()
            .contentType("application/json")
            .body("'code'", numberMatches(1.0))
            .body("'type'", containsString("error"))
            .body("'message'", containsString("User not found"));

  }


  @Test @Timeout(60)
  public void test_13() throws Exception {

    given().accept("application/json")
            .get(baseUrlOfSut + "/v2/pet/858")
            .then()
            .statusCode(404)
            .assertThat()
            .contentType("application/json")
            .body("'code'", numberMatches(1.0))
            .body("'type'", containsString("error"))
            .body("'message'", containsString("Pet not found"));

  }


  @Test @Timeout(60)
  public void test_14() throws Exception {

    given().accept("*/*")
            .header("api_key", "_EM_6_XYZ_")
            .delete(baseUrlOfSut + "/v2/pet/257")
            .then()
            .statusCode(404)
            .assertThat()
            .body(isEmptyOrNullString());

  }


  @Test @Timeout(60)
  public void test_15() throws Exception {

    given().accept("*/*")
            .delete(baseUrlOfSut + "/v2/store/order/455")
            .then()
            .statusCode(404)
            .assertThat()
            .contentType("application/json")
            .body("'code'", numberMatches(404.0))
            .body("'type'", containsString("unknown"))
            .body("'message'", containsString("Order Not Found"));

  }


  @Test @Timeout(60)
  public void test_16() throws Exception {

    given().accept("*/*")
            .delete(baseUrlOfSut + "/v2/user/_EM_12_XYZ_")
            .then()
            .statusCode(404)
            .assertThat()
            .body(isEmptyOrNullString());

  }


  @Test @Timeout(60)
  public void test_17() throws Exception {

    given().accept("application/json")
            .get(baseUrlOfSut + "/v2/store/order/8")
            .then()
            .statusCode(404)
            .assertThat()
            .contentType("application/json")
            .body("'code'", numberMatches(1.0))
            .body("'type'", containsString("error"))
            .body("'message'", containsString("Order not found"));

  }


  @Test @Timeout(60)
  public void test_18() throws Exception {
    ExpectationHandler expectationHandler = expectationHandler();

    ValidatableResponse res_0 = given().accept("*/*")
            .get(baseUrlOfSut + "/:-1/v2/swagger.json")
            .then()
            .statusCode(404)
            .assertThat()
            .contentType("text/html");

    expectationHandler.expect(ems)
            /*
             Note: No supported codes appear to be defined. https://swagger.io/docs/specification/describing-responses/.
             This is somewhat unexpected, so the code below is likely to lead to a failed expectation
            */
            .that(sco, Arrays.asList().contains(res_0.extract().statusCode()));
  }


  @Test @Timeout(60)
  public void test_19() throws Exception {
    ExpectationHandler expectationHandler = expectationHandler();

    ValidatableResponse res_0 = given().accept("application/json")
            .contentType("application/x-www-form-urlencoded")
            .body("")
            .post(baseUrlOfSut + "/v2/pet/419/uploadImage")
            .then()
            .statusCode(415)
            .assertThat()
            .contentType("application/json")
            .body("'code'", numberMatches(415.0))
            .body("'type'", containsString("unknown"));

    expectationHandler.expect(ems)
            .that(sco, Arrays.asList(200).contains(res_0.extract().statusCode()));
  }


}
