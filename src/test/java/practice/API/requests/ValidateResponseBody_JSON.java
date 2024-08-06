package practice.API.requests;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.invokers.InvokeMethodRunnable.TestNGRuntimeException;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseBody_JSON {
	//https://reqres.in/api/users?page=2
	
	@Test
	public void validateJSONResponseBody() {

		//get Requestspecification reference
		RequestSpecification reqspec= given();
		
		//Specify baseUri and basePath
		reqspec.baseUri("https://reqres.in");
		reqspec.basePath("/api/users?page=2");
		
		//Perform Get request
		Response response = reqspec.get();
		
	//	Response response= get("https://reqres.in/api/users?page=2");
		
		//read response body
		ResponseBody responseBody = response.getBody();
		
		
		
		//Store response body as string
		String responseString= responseBody.asPrettyString();
		
		System.out.println("Response Body : " + responseString);
		
		JsonPath jsonpath = responseBody.jsonPath();
		
		//String name = response.jsonPath().get("data[0].first_name");
		
		String name = jsonpath.get("data[0].first_name");
			
		
		System.out.println("Name 1st first place: " +name);
		Assert.assertEquals(name, "George", "Expected Name not present");
		
		String LN= response.getBody().jsonPath().get("data[0].last_name");
		System.out.println("Name 1st Last place: " +LN);
		
		//check for presense on name Tracy
		
		Assert.assertEquals(responseString.contains("Tracey"),true, "Expected Name not present");
		
	
	}
	
	
}
