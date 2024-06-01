package api.endpoints;
/*
URI : http://jsonplaceholder.typicode.com/

GET users (GET): https://jsonplaceholder.typicode.com/users/{userId}
		 (GET): https://jsonplaceholder.typicode.com/users/{userId}/todos
*/
public class Routes {
	
	public static String base_url="http://jsonplaceholder.typicode.com";
	
	//User Module
	public static String readUser_url= base_url+"/users/{userId}";
	public static String readUserTasks_url= base_url+"/users/{userId}/todos";
	
}
