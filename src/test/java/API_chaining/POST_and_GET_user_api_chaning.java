package API_chaining;

import org.testng.Assert;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;




public class POST_and_GET_user_api_chaning {
	
	String messagevalue;
	
	@Test(priority = 1)
	public void create_user() {
		
       RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response response = given()
		
		.body("{\r\n"
				+ "  \"id\": 1,\r\n"
				+ "  \"username\": \"new test\",\r\n"
				+ "  \"firstName\": \"postman71\",\r\n"
				+ "  \"lastName\": \"user81\",\r\n"
				+ "  \"email\": \"postm8an.user@att.com\",\r\n"
				+ "  \"password\": \"test1123\",\r\n"
				+ "  \"phone\": \"993783197833\",\r\n"
				+ "  \"userStatus\": 0\r\n"
				+ "}")
		.header("Content-Type", "application/json")
		
		.log().all()
		
		.when()
		
		.post("/user")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		JsonPath jp = response.jsonPath();
		
		 messagevalue = jp.getString("message");
		
		System.out.println("message value: "+messagevalue);
		
	
	}
//	@Test(priority = 2)
//	public void getuser_detail() {
//        RestAssured.baseURI = "https://petstore.swagger.io/v2";
//		
//		Response response = given()
//		
//		.pathParam("createdusername", "restassureduser")
//		
//		.when()
//		
//		.get("/user/{createdusername}")
//				
//		.then()
//				
//		.log().all()
//		
//		.extract()
//		
//		.response();
//		
//		
//		JsonPath jp = response.jsonPath();
//		
//		String idvalue= jp.getString("id");
//		
//		System.out.println("ID value is : "+idvalue);
//			
//		Assert.assertEquals(idvalue, messagevalue);
//	}

}
