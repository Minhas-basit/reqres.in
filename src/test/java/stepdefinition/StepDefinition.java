package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import pojo.Json;
import pojo.Payload;
import resources.BaseData;
import resources.EndPoints;

import static io.restassured.RestAssured.given;

import java.io.IOException;

public class StepDefinition extends BaseData {
	RequestSpecification reqspec;
	RequestSpecification userRequest;
	Response resp;
	String id;
	
	
	
	@Given("User is created with {string} and {string} payload")
	public  RequestSpecification user_is_created_with_and_payload(String name, String job) throws IOException {

		Payload pl = new Payload();
		Json jsonObject = pl.jsonPayload(name, job);
		reqspec = given().spec(requestBuilder()).body(jsonObject);
		return reqspec;

	}

	@When("User is created with http {string} request")
	public void user_is_created_with_http_request(String method) {
		EndPoints ep = EndPoints.valueOf(method);

		resp = reqspec.when().post(ep.getEndPoints());
	}

	@Then("User ID is generate")
	public void user_id_is_generate() {
		String end = resp.then().extract().response().asString();
		JsonPath js = new JsonPath(end);
		id = js.get("id");
		Assert.assertEquals(resp.getStatusCode(), 201);

	}
	
	@Given("user is created")
	public void user_is_created() {
	
	}
	@When("user is deleted with http {string} request")
	public void user_is_deleted_with_http_request(String string) {
	    
	}
	@Then("status code is {int}")
	public void status_code_is(Integer int1) {
	   
	}




}
