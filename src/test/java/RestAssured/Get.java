package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get {
	public static RequestSpecification given;
     public static void main(String[] args) {
    	 RestAssured.baseURI="https://reqres.in/";
		given = RestAssured.given();
		given.header("x-api-key","reqres-free-v1");
		Response response = given.request(Method.GET , "/api/users");
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		String asPrettyString = response.getBody().asPrettyString();
		System.out.println(asPrettyString);
		
		
	}
}
