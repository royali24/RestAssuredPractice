package practice.API.requests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParameters {

	@Test
	public void queryParameters() {
		
		//Specify RequestSpecification to specify how the request will look like

		RequestSpecification requestSpecification = RestAssured.given();
		
		requestSpecification.baseUri("https://reqres.in");
		requestSpecification.basePath("/api/users");
		//enter the query parameter od the URL
		requestSpecification.queryParam("page", 1);
		
		//Send the Get request and store it in Response
		Response response= requestSpecification.get();
		//Store response as a string
		String responseString = response.asPrettyString(); 
		System.out.println("Response got after Get request: " +responseString);
		
		//Enter multiple query parameters to fetch exact data
		requestSpecification.queryParam("page", 1).and().queryParam("id", 5);
		response= requestSpecification.get();
		responseString = response.asPrettyString();
		System.out.println("\n\nResponse got after multiple query parameter Get request : " +responseString);
		
		//Get a JsonPath view of the response body
		JsonPath jsonPath= response.jsonPath();
		
		//parse through Json path to get the data
		String lastname = jsonPath.get("data.last_name");
		System.out.println("Lastname of id 5: " + lastname);
		Assert.assertEquals(lastname, "Morris", "Last Name Mismatch: Please check again");
	}
}
