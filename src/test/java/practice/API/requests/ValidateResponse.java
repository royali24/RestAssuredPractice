package practice.API.requests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ValidateResponse {
	@Test
	public void ValidateResponseStatus01() {
		baseURI ="https://reqres.in/api/users/2";
		
		RequestSpecification reqspec = given();
		Response resp= reqspec.get();
		
		int StatusCode= resp.getStatusCode();
		System.out.println("The response code is :" + StatusCode);
		Assert.assertEquals(200, StatusCode);
		
		String StatusLine= resp.getStatusLine();
		System.out.println("The response line is :" + StatusLine);
		Assert.assertEquals("HTTP/1.1 200 OK", StatusLine);
		
		//try with ValidatableResponse class	
		ValidatableResponse valresp = resp.then();
		valresp.statusCode(200);
		
		
	}
	@Test 
	public void ValidateResponseStatus_BDD() {
		baseURI ="https://reqres.in/api/users/2";
		
		given().
		when().
			get().
		then().
			statusCode(200).
			statusLine("HTTP/1.1 200 OK");
		
	}
}
