package apis;

import static io.restassured.RestAssured.given;
import static apis.GetToken.getAccessToken;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class GetUserId {
	 
	 
	public static String getUserDetails() {
		
		Response response = given()
		  .baseUri("https://api.spotify.com/v1")
		  .header("Authorization","Bearer "+ getAccessToken())		  	  
		.when()
		  .get("/me")	
		.then().extract().response();
		
		String userId= response.path("id");
		System.out.println("userid====> "+ userId);
		
		return response.path("id");
		
		 
	}
	

}
