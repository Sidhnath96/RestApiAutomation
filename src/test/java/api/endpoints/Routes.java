package api.endpoints;

// keep all the required  end points or urls here

//swagger url - https://petstore.swagger.io/v2/user/
//Get-user url - https://petstore.swagger.io/v2/user/{username}
//Create user (Post-user) - https://petstore.swagger.io/v2/user
//Update user url - https://petstore.swagger.io/v2/user/{username}
//Delete user url- https://petstore.swagger.io/v2/user/{username}

public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2/";

	// User Module

	public static String post_user_url = base_url + "user";

	public static String get_user_url = base_url + "user/{username}";

	public static String update_user_url = base_url + "user/{username}";

	public static String delete_user_url = base_url + "user/{username}";

	// Pet Module

		// here you will create pet module urls

	// Store Module

		// here you will create store module urls

}
