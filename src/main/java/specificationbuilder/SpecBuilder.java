package specificationbuilder;

import static apis.GetToken.getAccessToken;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
 
public class SpecBuilder {
	
	
	public static RequestSpecification requestSpecBuilder() {
		
		return new RequestSpecBuilder()
				 .setBaseUri("https://api.spotify.com/v1")		         
		         .setContentType(ContentType.JSON)
		         .log(LogDetail.ALL)
		         .build();
		
	}
	
	
	public static ResponseSpecification responseSpecBuilder() {
		
		return new ResponseSpecBuilder().log(LogDetail.ALL).build();
		
	}

}
