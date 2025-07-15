package tests;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import specificationbuilder.SpecBuilder;

public class GetPlaylist {
	
	
	
	
	@Test
	public void fetchPlaylists(ITestContext context) {	 
	
		String playlistId = (String) context.getAttribute("playlist_id");
		System.out.println("Fetched: "+ playlistId);
		
	     Response response=	given(SpecBuilder.requestSpecBuilder()) 	
		                   .when()
			                  .get("/playlists/"+playlistId)	
			               .then().spec(SpecBuilder.responseSpecBuilder()).assertThat().statusCode(200).extract().response();

         String playlist_id = response.path("id");
		System.out.println(playlist_id );
		
	}
	

}
