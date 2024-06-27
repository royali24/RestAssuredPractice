import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstGetRequest {
	String URL = "https://reqres.in";
	//https://reqres.in/api/users/2
	@Test
	void testcase01()
	{
		Response response = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(response.asPrettyString());
	}

}
