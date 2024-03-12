package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	// generate the required payload and parallely set the data to the variable created in User class
	
	
	Faker faker;
	User userpayload;
	
	@BeforeClass
	void genrateData()
	{
		faker = new Faker();
		userpayload = new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setPassword(faker.internet().password());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
	
//		System.out.println(userpaload.getId());
//		System.out.println(userpaload.getUsername());
//		System.out.println(userpaload.getFirstName());
//		System.out.println(userpaload.getLastName());
//		System.out.println(userpaload.getEmail());
//		System.out.println(userpaload.getPassword());
//		System.out.println(userpaload.getPhone());
		
	}
	
	
	@Test(priority =1)
	void testPostUserApi()
	{
		Response response= UserEndPoints.createUser(this.userpayload);
		
		//response.then().log().all();
		
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.getHeader("Content-Type"),"application/json");
		
	}
	
	
	@Test(priority=2)
	void testGetUserApi()
	{
		Response response = UserEndPoints.getUser(this.userpayload.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(),200);
		
		Integer id = (Integer)response.jsonPath().get("id");
		Assert.assertEquals(this.userpayload.getId(),id);
		Assert.assertEquals(response.jsonPath().get("username"), this.userpayload.getUsername());

	}
	
	@Test(priority=3)
	void testUpdateUserApi()
	{
		// here i will update first name last name and email using payload
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setEmail(faker.internet().emailAddress());
		
		Response response=UserEndPoints.updateUser(userpayload, userpayload.getUsername());
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		
		// checking the updated data 
		
		
	}
	
	@Test(priority =4)
	void testDeleteUser()
	{
		Response response=UserEndPoints.deleteUser(this.userpayload.getUsername());
		
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	
	
	
	

}
