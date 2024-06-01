package api.test;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.aventstack.extentreports.ExtentReports;
import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.User;

import io.restassured.response.Response;

public class UserTodoTests  {
	
	private ExtentReports extent;
	public Logger logger;
	
	public class TestBase {

		Faker faker;
		User userPayload;

		@BeforeClass
		public void setup() {
			
			//Logger class
			logger =LogManager.getLogger(this.getClass());
			faker = new Faker();
			userPayload = new User();
			userPayload.setId(faker.number().numberBetween(1, 11));
			logger.info("Current Testing UserId is: " + userPayload.getId());

		}

		@Test
		public void testUsersTodosFromFanCodeCity() {
			logger.info("Entering into - Reading User from the service");
			Response response = UserEndPoints.readUsers(userPayload.getId());
			Assert.assertEquals(response.getStatusCode(), 200);
			response.then().log().all();
			logger.info("***********Successfully retrieved user for Id: " + userPayload.getId()+" ************" );

			Gson gson = new Gson();
			User user = gson.fromJson(response.asString(), User.class);

			double lat = Double.parseDouble(user.getAddress().getGeo().getLat());
			logger.info("Latitude of User City=" + lat);
			double lng = Double.parseDouble(user.getAddress().getGeo().getLng());
			logger.info("Longitude of User City=" + lng);

			if (isInFanCodeCity(lat, lng)) {
				logger.info("User is the citizen of Fancode");
				verifyUserTodosCompletion(userPayload.getId());
			}else {
				logger.info("User is not the citizen of Fancode");
			}
		}
		
	}

	private boolean isInFanCodeCity(double lat, double lng) {
		return lat > -40 && lat < 5 && lng > 5 && lng < 100;
	}

	private void verifyUserTodosCompletion(int userId) {
		
		logger.info("Entering into Reading User ToDo's Task from the service");
		Response response = UserEndPoints.readUsersTasks(userId);
		response.then().log().all();
		logger.info("***********Successfully retrieved UserTasks for Id: " + userId+" ************" );
		Assert.assertEquals(response.getStatusCode(), 200);
		
		List<Map<String, Object>> todos = response.jsonPath().getList("$");

		long totalTodos = todos.size();
		logger.info("Total ToDo's Task in the name of user: "+ totalTodos);
		
		long completedTodos = todos.stream().filter(todo -> (Boolean) todo.get("completed")).count();
		logger.info("Completed ToDo's Task in the name of user: "+ completedTodos);
		logger.info("Pending ToDo's Task in the name of user: "+ (totalTodos-completedTodos));
		
		Assert.assertTrue(completedTodos > totalTodos / 2, "User " + userId + " should have more than 50% todos completed");
	}
	
	 @AfterClass
	    public void tearDown() {
	        extent.flush();
	    }

}
