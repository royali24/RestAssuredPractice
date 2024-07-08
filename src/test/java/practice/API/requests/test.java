package practice.API.requests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class test {

	@Test
	public void getmethod() {
		baseURI ="https://reqres.in/api/users/2";
		
		Response res= get();
		System.out.println(res.statusCode());
	} 
}
