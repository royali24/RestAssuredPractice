package deserialization;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class JSONdeserialization {

	@Test
	public void createUser() {
		
		//https://reqres.in/api/users
		//create Request Specification
		RequestSpecification requestSpec = RestAssured.given();
		//specify URL
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users");

		//create request body
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Looney");
		jsonData.put("job", "Lovegood");



		//perform post request
		Response response = requestSpec.
				contentType(ContentType.JSON).
				body(jsonData.toJSONString()).
				post();


		ResponseBody responseBody = response.getBody();

		System.out.println(responseBody.asPrettyString());
		System.out.println("Status Line: "+response.getStatusLine());

		//Deserialize response body ie JSON response body to class oblect (class -> JSONPOSTResponseDAta)

		JSONPostResponseData jsonresponseobj = responseBody.as(JSONPostResponseData.class);

		
		//Try Assertions now 
		Assert.assertEquals(jsonresponseobj.name, "Looney", "Error Message: Check name");

		Assert.assertEquals(jsonresponseobj.job, "Lovegood", "Error Message: Check job");
		


	}
}
