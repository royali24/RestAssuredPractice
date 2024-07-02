package practice.API.requests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
//https://reqres.in/api/users/732
	/*{
	 * "name", "chamku mangu"
	 * "job", "youtuber"
	 * }
	 */
public class TestPutMethod {
	@Test
	public void testPut01() {
		baseURI = "https://reqres.in/api/users/770";
		
		JSONObject updateJson = new JSONObject();
		updateJson.put("name", "chamkumangu");
		updateJson.put("job", "youtuber");
		
		given()
		.header("Content-Type", "application/json")
		.body(updateJson.toJSONString())
		.when().put()
		.then().statusCode(200).log().all();
	}

}
