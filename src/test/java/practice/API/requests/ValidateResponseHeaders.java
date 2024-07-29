package practice.API.requests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeaders {
	
	@Test
	public void validateHeader01() {
			baseURI ="https://reqres.in/api/users/2";
			
			RequestSpecification reqspec= given();
			Response response = reqspec.get();
			//Response response = get();  -- instead of above 2 lines you can simply write this 1 line
			Headers headers_list = response.getHeaders();
			int total_headers_count = headers_list.size();
			
			System.out.println("The total number of headers present in response: " +total_headers_count);
			
			if(total_headers_count>0) {
				for(Header header : headers_list) {
					System.out.println("Header_Attribute: " + header.getName() + "  Header_Value: " +header.getValue());
				}
			}
			
			String content_type = response.getHeader("Content-Type");
			System.out.println("Value of Content-Type: " +content_type);
			String CF_RAY_value = response.getHeader("CF-RAY");
			System.out.println("Value of CF_RAY_value: " +CF_RAY_value);
			
	}
}
