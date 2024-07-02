package practice.API.requests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TestPostMethod {
	/*Post Request
	{
		name = royali
		job = AI Developer
	}
	*/
	@Test (enabled = false)
	public void testPost01() {
		
		JSONObject jsonData= new JSONObject();
		jsonData.put("name", "Royali");
		jsonData.put("job", "AI Developer");
		
		baseURI ="https://reqres.in/api/users";
		
		given()
		.body(jsonData.toJSONString())
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.when().post()
		.then().statusCode(201).log().all();
	}
	@Test
	public void testGetAfterPost01() {
		
		JSONObject jsonData1= new JSONObject();
		jsonData1.put("name", "Sumona");
		jsonData1.put("job", "Tester");
		
		baseURI ="https://reqres.in/api/users";
		
		given()
		.body(jsonData1.toJSONString())
		.header("Content-Type", "application/json")
		.contentType(ContentType.JSON)
		.when().post()
		.then().statusCode(201).log().body();

		
	}

	
	
}
