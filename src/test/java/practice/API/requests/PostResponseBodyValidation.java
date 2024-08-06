package practice.API.requests;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class PostResponseBodyValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RequestSpecification reqspec = RestAssured.given();
		reqspec.baseUri("https://reqres.in");
		reqspec.basePath("/api/users");
		
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", "Coffee");
		jsonObj.put("job", "dog");
		
		Response response=  reqspec
		.accept(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.post();
		
		ResponseBody responseBody = response.getBody();
		
		System.out.println(responseBody.asPrettyString());
		System.out.println(response.getStatusLine());
		
		System.out.println( "id:" +responseBody.jsonPath().get("id"));
		
		/* if response body was like 
		 * {
    			"name": "Coffee",
    			"job": "Dog",
    			"id": "944",
    			"createdAt": "2024-08-06T00:01:47.511Z"
			}	
		 * 
		 * then we could have used Assert method to verify the post data
		 * 
		 * String name_in_response_body = responseBody.jsonPath().get("name");
		 * Assert.assertequals(name_in_response_body, "Coffee", "Error: Check name correctly");
		 * 
		 * */
		
	}

}
