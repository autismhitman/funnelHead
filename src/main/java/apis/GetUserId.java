package apis;

import static apis.TokenManager.getToken;
import static io.restassured.RestAssured.given;

import io.qameta.allure.Step;
import io.restassured.response.Response;
public class GetUserId {
	 
	@Step 
	public static String getUserDetails() {
		
		Response response = given()
		  .baseUri("https://api.spotify.com"+ Routes.BASE_PATH)
		  .auth().oauth2(getToken())	 	  	  
		.when()
		  .get(Routes.USER_PROFILE)	
		.then().extract().response();
		
		String userId= response.path("id");
		System.out.println("userid====> "+ userId);
		
		return response.path("id");
		
		 
	}
	

}
