package com.simplilearn;

import java.util.HashMap;

import org.junit.Test;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class PostRequest {
	public class POSTRequest extends TestBase {

		public  HashMap<String, String> map = new HashMap<String, String>();
			
			@BeforeMethod
			public void createPOSTData() {
				
				map.put("id", "371");
				map.put("email", "guptapragatigoogle.com");
				map.put("first_name", "Pragati");
				map.put("last_name", "Gupta");
				map.put("avatar", "https://reqres.in/img/faces/1-image.jpg");
				
				RestAssured.baseURI = "https://reqres.in";
				RestAssured.basePath = "/api/users";
				logger.info("BaseURL specified");
			}
			
			@Test
			public void verifyResponse() {
				logger.info("Inside POST method");
				RestAssured
					.given()
						.contentType("application/json")
						.body(map)
					.when()
						.post()
					.then()
						.assertThat()
						.statusCode(201)
					.and()
						.body("email", is("guptapragati@google.com"))
						.log().all();
				logger.info("Response Code Verified");
				
				
				
				//System.out.println(RestAssured.given().get().body().asString());

				
			}

			private ResponseAwareMatcher<Response> is(String string) {
				// TODO Auto-generated method stub
				return null;
			}
			
		}

}
