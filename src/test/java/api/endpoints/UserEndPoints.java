package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class UserEndPoints {
	
	// UserEndPoints.java --> created for CRUD operation of user module 
	
	
	public static Response createUser(User user_payload)
	{
		Response response= given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(user_payload)
		.when()
			.post(Routes.post_user_url);
		
		return response;
		// we have to capture the response in here so that validation part will done in test case class
	}
	
	
	public static Response getUser(String userName)
	{
		Response response =given()
		.accept(ContentType.JSON)
		.pathParam("username", userName)
			
		.when()
			.get(Routes.get_user_url);
		return response;
	}
	
	

	public static Response updateUser(User updateuser_payload , String userName)
	{
		Response response= given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.pathParam("username", userName)
			.body(updateuser_payload)
		.when()
			.put(Routes.update_user_url);
		
		return response;
		
	}
	
	
	public static Response deleteUser(String userName)
	{
		Response response =given()
		.accept(ContentType.JSON)
		.pathParam("username", userName)
			
		.when()
			.delete(Routes.delete_user_url);
		return response;
	}
	
	
}
