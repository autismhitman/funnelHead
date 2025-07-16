package specificationbuilder;

import apis.Routes;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
 
public class SpecBuilder {
	
	@Step
	public static RequestSpecification requestSpecBuilder() {
		
		return new RequestSpecBuilder()
				 .setBaseUri("https://api.spotify.com"+ Routes.BASE_PATH)		         
		         .setContentType(ContentType.JSON)
		         .addFilter(new AllureRestAssured())
		         .log(LogDetail.ALL)
		         .build();
		
	}
	
	@Step
	public static RequestSpecification accountRequestSpecBuilder() {
		
		return new RequestSpecBuilder()
				 .setBaseUri("https://accounts.spotify.com"+ Routes.API)		         
				 .setContentType(ContentType.URLENC)
				 .addFilter(new AllureRestAssured())
		         .log(LogDetail.ALL)
		         .build();
		
	}
	
	@Step
	public static ResponseSpecification responseSpecBuilder() {
		
		return new ResponseSpecBuilder().log(LogDetail.ALL).build();
		
	}

}
 