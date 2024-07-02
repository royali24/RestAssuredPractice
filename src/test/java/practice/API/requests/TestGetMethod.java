package practice.API.requests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class TestGetMethod {
	
	//print response code,response time , response header and response body
	//https://reqres.in/api/users/2
	
	@Test
	public void test01(){
		
		Response response= get("https://reqres.in/api/users/2");
		String response_body= response.getBody().asPrettyString();
		System.out.println("Response Body: " +response_body);
		
		int response_code =response.getStatusCode();
		System.out.println("Response Code: " +response_code);
		
		long response_time= response.getTime();
		System.out.println("Response Time: " +response_time);
		
		String response_header =response.getHeader("Content-Type");
		System.out.println("Response Header: " +response_header);
		
		
		//validate Status code
		int expected_response_code=200;
		Assert.assertEquals( expected_response_code,response_code);
	}
	
	//execute in BDD style
	@Test
	public void test02() {
		
		//given, when, then
		baseURI="https://reqres.in/api/users";
		
		given().queryParams("page","2")
			.when().get()
			.then().statusCode(200);
	}
}
