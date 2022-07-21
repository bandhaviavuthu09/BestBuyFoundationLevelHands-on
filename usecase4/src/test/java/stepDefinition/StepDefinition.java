package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;

public class StepDefinition{
	ResponseSpecification resspec;
	RequestSpecification res;
	Response response;

	@Given("Create Service Payload with name")
	public void create_Service_Payload_with_name() {
	    // Write code here that turns the phrase above into concrete action
		
		RestAssured.baseURI = "http://localhost:3030";		
		RequestSpecification req =new RequestSpecBuilder().setBaseUri("http://localhost:3030")
								.setContentType(ContentType.JSON).build();		 
		resspec =new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
		res=given().spec(req).body(
				"{\r\n"
				+ "  \"name\": \"service to be updated\"\r\n"
				+ "}"
				);		
	    
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		
		response=res.when().post("services").then().spec(resspec).extract().response();
		

	}

	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		
		Assert.assertEquals(response.getStatusCode(), 201);

	}


}
