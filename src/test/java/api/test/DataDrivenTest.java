package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProvider;
import io.restassured.response.Response;

public class DataDrivenTest {

	// if data provider and data user method present in the same class we can
	// specify the name of dataprovider only
	// But here both are in separate class then need to write a parameter-->
	// dataProviderClass = DataProvider.class

	
	// data provider will provide the data and we need to capture it in the method
	// so create same sequence (we need not to use any looping statements while using data provider)
	// of variable to get the data as a parameter of the method (sequence is imp)
	

	@Test(priority = 1, dataProvider = "name of the data provider", dataProviderClass = DataProvider.class)
	public void testPostUser(String userid, String username, String fname, String lname, String pwd, String ph) {
		
		
		// we are sending payload to the request through User class so the we need to
		// set the data first
		// to user class and then get it from that class

		User payload = new User();

		payload.setId(Integer.parseInt(userid));
		payload.setFirstName(fname);
		payload.setUsername(username);
		payload.setLastName(lname);
		payload.setPassword(pwd);
		payload.setPhone(ph);
		
		
		// send the request using payload and validate required fields 

		Response response = UserEndPoints.createUser(payload);

		// response.then().log().all();

		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json");

	}

}
