package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import java.io.IOException;

import Resources.APIResource;
import Resources.Utils;


public class RateApiStepDefinitions extends Utils{

	RequestSpecification req;
	Response response;
	JsonPath js;
	APIResource resourceAPI;

	@Given("Exchange Rate API Uri is accessible")
	public void exchange_Rate_API_Uri_is_accessible() throws IOException {
		req = given().spec(requestSpecification());
	
		//System.out.println(req);
	}
	
	@Given("user calls {string} endpoint")
	public void user_calls_endpoint(String resource) throws IOException {
		resourceAPI = APIResource.valueOf(resource);
	}
	
/*	@Given("request for specific exchange rates with {string} {string}")
	public void request_for_specific_exchange_rates_with(String key, String value) throws IOException {
		req = given().spec(requestSpecification()).queryParam(key, value);
	}
	*/
	
	@Given("request for specific exchange rates with {string} {string} {string} {string}")
	public void request_for_specific_exchange_rates_with(String key1, String value1, String key2, String value2) throws IOException {
			req = given().spec(requestSpecification()).queryParams(key1, value1).queryParams(key2, value2);
		
	}
	
	@When("user makes a {string} http request call")
	public void user_makes_a_http_request_call(String method) {
		if(method.equalsIgnoreCase("GET"))
			response = req.when().get(resourceAPI.getResource());
		//System.out.println(response);
	}	

	@Then("the API call gets status code {int}")
	public void the_API_call_gets_status_code(Integer code) {
		assertEquals(response.getStatusCode(), 200);
	}
	
	@Then("the API call gets an error {string}")
	public void the_API_call_gets_an_error(String expectedErrorMessage) {
		js = new JsonPath(response.asString());
		String ActualErrorMessage = js.get("error");
		assertEquals(ActualErrorMessage, expectedErrorMessage);
		
	}
}
