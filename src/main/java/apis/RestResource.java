package apis;

import io.restassured.response.Response;

import static apis.TokenManager.getToken;
import static io.restassured.RestAssured.*;

import java.util.Map;

import io.restassured.http.ContentType;
import specificationbuilder.SpecBuilder;

public class RestResource {
	
	public static Response post(String path, Object playlist) {
		
		return given(SpecBuilder.requestSpecBuilder())
				  .auth().oauth2(getToken())
	            .body(playlist)
	       .when()
	  		 .post(path)	
	  		.then().spec(SpecBuilder.responseSpecBuilder())	  	 
	  		.extract().response();
		}
	
	public static Response post(Map<String, String> map) {
		
		return  given(SpecBuilder.accountRequestSpecBuilder())		   
				  .formParams(map)
				.when()
				  .post(Routes.TOKEN)	
				.then().extract().response();
	}
	
	public static Response get(String path) {
		
		return given(SpecBuilder.requestSpecBuilder()).auth().oauth2(getToken()) 	
                .when()
	                  .get(path)	
	               .then().spec(SpecBuilder.responseSpecBuilder()).extract().response();
		}
	
	
	public static Response put(String path, Object playlist) {
		
		return  given(SpecBuilder.requestSpecBuilder()).auth().oauth2(getToken())
				.body(playlist)
			.when()
			    .put(path)	
			.then().spec(SpecBuilder.responseSpecBuilder()).extract().response();
		}

}
