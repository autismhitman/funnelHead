package tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import pojo.Playlist;
import specificationbuilder.SpecBuilder;

public class UpdatePlaylist {
	
	
	@Test
	public void modifyPlaylists(ITestContext context) {
		
		Playlist pl = new Playlist().setName("Tesla New").setDescription("Elon musk New").setPublic(false);
	 	
		
		
		              given(SpecBuilder.requestSpecBuilder()) 
										.body(pl)
									.when()
									    .put("/playlists/"+ (String) context.getAttribute("playlist_id"))	
									.then().spec(SpecBuilder.responseSpecBuilder()).assertThat().statusCode(200);
         
	 
	}
	

}
