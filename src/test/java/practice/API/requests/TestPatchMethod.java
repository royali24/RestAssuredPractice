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
public class TestPatchMethod {
	@Test
	public void testPatch01() {
		baseURI = "https://reqres.in/api/users/752";
		
		JSONObject updateJson = new JSONObject();
		updateJson.put("name", "hoopla");
		updateJson.put("job", "joomla");
		
		given()
			.header("Content-Type", "application/json")
			.body(updateJson.toJSONString())
		.when()
			.patch()
		.then()
			.statusCode(200)
			.log().all();
	}

}
