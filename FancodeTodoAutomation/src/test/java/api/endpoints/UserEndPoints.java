package api.endpoints;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class UserEndPoints {
	
	public static Response readUsers(int userId) {
		Response response = given().pathParam("userId", userId)
				.when()
		.get(Routes.readUser_url);
		
		return response;
	}
	
	public static Response readUsersTasks(int userId) {
		Response response = given().pathParam("userId", userId)
				.when()
		.get(Routes.readUserTasks_url);
		
		return response;
	}
	
}
