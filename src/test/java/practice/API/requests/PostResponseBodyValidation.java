package practice.API.requests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class PostResponseBodyValidation {

	@Test
	public  void createUser() {
		// TODO Auto-generated method stub

		RequestSpecification reqspec = RestAssured.given();
		reqspec.baseUri("https://reqres.in");
		reqspec.basePath("/api/users");


		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", "Coffee");
		jsonObj.put("job", "dog");

		Response response=  reqspec
				.contentType(ContentType.JSON)
				.body(jsonObj.toJSONString())
				.post();

		ResponseBody responseBody = response.getBody();

		System.out.println(responseBody.asPrettyString());
		System.out.println(response.getStatusLine());

	

		 String name_in_response_body = responseBody.jsonPath().get("name");
		 Assert.assertEquals(name_in_response_body, "Coffee", "Error: Check name correctly");
		 
		 Assert.assertEquals(responseBody.jsonPath().get("job"), "dog");
		 
		 //System.out.println( "id:" +responseBody.jsonPath().get("id"));
		

	}

}
