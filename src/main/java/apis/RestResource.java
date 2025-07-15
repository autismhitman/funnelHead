package apis;

import io.restassured.response.Response;

import static apis.GetToken.getAccessToken;
import static io.restassured.RestAssured.*;
import specificationbuilder.SpecBuilder;

public class RestResource {
	
	public static Response post(String path, Object playlist) {
		
		return given(SpecBuilder.requestSpecBuilder())
				.header("Authorization","Bearer "+ getAccessToken())	
	           .body(playlist)
	       .when()
	  		 .post(path)	
	  		.then().spec(SpecBuilder.responseSpecBuilder())	  	 
	  		.extract().response();
		}
	
	
	public static Response get(String path, Object playlist) {
		
		return given(SpecBuilder.requestSpecBuilder())
				.header("Authorization","Bearer "+ getAccessToken())	
	           .body(playlist)
	       .when()
	  		 .post(path)	
	  		.then().spec(SpecBuilder.responseSpecBuilder())	  	 
	  		.extract().response();
		}

}
