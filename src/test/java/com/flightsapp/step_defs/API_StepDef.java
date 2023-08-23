package com.flightsapp.step_defs;

import com.flightsapp.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class API_StepDef {

    private String url = ConfigurationReader.getProperty("api_url");
    private Response response;

    @When("user sends a GET request to the endpoint")
    public void user_sends_a_get_request_to_the_endpoint() {
        response = given().accept(ContentType.JSON)
                .when()
                .get(url);
    }
    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer code) {
        response.then().statusCode(code);
    }
    @Then("the response body should match the json schema")
    public void the_response_body_should_match_the_json_schema() {
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("FlightsResultSchema.json")).log().all();
    }

    @Then("the response should contain the {string} header")
    public void the_response_should_contain_the_header(String header) {
        assertTrue(response.headers().hasHeaderWithName(header));
    }
    @Then("the Content-Type header should have the value {string}")
    public void the_content_type_header_should_have_the_value(String value) {
        response.then().header("Content-Type", value).log().all();
    }



}
