package practice.API.requests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TestDeleteMethod {

	@Test
	public void testDelete01() {
		
	baseURI = "https://reqres.in/api/users/752";
	
	given().
	when()
		.delete().
	then()
	    .log().all()
	    .statusCode(204);
	
	}
}
