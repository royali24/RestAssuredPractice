package practice.API.requests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthorizationToken_BasicDigest {
	
	//https://postman-echo.com/basic-auth
	
	@Test
	public void BasicAuthorization() { 
	//RequestSpecification to specify how the request would look like	
	RequestSpecification requestSpecification= RestAssured.given();
	
	//Mention the URLs
	requestSpecification.baseUri("https://postman-echo.com");
	requestSpecification.basePath("basic-auth");
	
	//Get response using basic authorization 
	Response response= requestSpecification.auth().basic("postman", "password").get();
	
	int status_code=response.getStatusCode();
	
	Assert.assertEquals(status_code, 200, "Status code mismatch: Check Authorization");
	
	System.out.println("Basic Response line: " + response.getStatusLine());
	
	}	
	
	@Test
	public void BasicAuthorization_preemptive() { 
		
	RequestSpecification requestSpecification= RestAssured.given();
	
	requestSpecification.baseUri("https://postman-echo.com");
	requestSpecification.basePath("basic-auth");
	
	Response response= requestSpecification.auth().preemptive().basic("postman", "password").get();
	
	int status_code=response.getStatusCode();
	
	Assert.assertEquals(status_code, 200, "Status code mismatch: Check Authorization");
	
	System.out.println("Preemptive Response line: " + response.getStatusLine());
	
	}	
	@Test
	public void DigestAuthorization() { 
		
	RequestSpecification requestSpecification= RestAssured.given();
	
	requestSpecification.baseUri("https://postman-echo.com");
	requestSpecification.basePath("digest-auth");
	
	Response response= requestSpecification.auth().digest("postman", "password").get();
	
	int status_code=response.getStatusCode();
	
	Assert.assertEquals(status_code, 200, "Status code mismatch: Check Authorization");
	
	System.out.println("Digest Response line: " + response.getStatusLine());
	
	}	
	
	
	@Test
	public void DigestAuthorizationUsingOwnURL() { 
		//https://httpbin.org/digest-auth/undefined/royali/roy 
		//https://httpbin.org
		
		
	RequestSpecification requestSpecification= RestAssured.given();
	
	requestSpecification.baseUri("https://httpbin.org");
	requestSpecification.basePath("digest-auth/undefined/royali/roy");
	
	Response response= requestSpecification.auth().digest("royali", "roy").get();
	
	int status_code=response.getStatusCode();
	
	Assert.assertEquals(status_code, 200, "Status code mismatch: Check Authorization");
	
	System.out.println("Digest HttpBin Response line: " + response.getStatusLine());
	
	System.out.println("Digest HttpBin Response Body: " + response.getBody().asPrettyString());
	
	}	
}
