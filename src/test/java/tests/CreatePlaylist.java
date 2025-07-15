package tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import pojo.Playlist;
import specificationbuilder.SpecBuilder;

public class CreatePlaylist {
	
	
	@Test
	public void createPlaylists(ITestContext context) {
		
		Playlist pl = new Playlist().setName("Tesla").setDescription("Elon musk").setPublic(false);
	 	
		Playlist responsePlaylist=	given(SpecBuilder.requestSpecBuilder())
		                                  .body(pl)
		                            .when()
			                        .post("/users/"+ apis.GetUserId.getUserDetails()+"/playlists")	
			.then().spec(SpecBuilder.responseSpecBuilder()).assertThat().statusCode(201).extract().response().as(Playlist.class);

         String playlist_id = responsePlaylist.getId();
         context.setAttribute("playlist_id", playlist_id);
		 System.out.println("playlist_id====> " + playlist_id );
		
		Assert.assertEquals(responsePlaylist.getName(), pl.getName());
		Assert.assertEquals(responsePlaylist.getDescription(), pl.getDescription());
		Assert.assertEquals(responsePlaylist.getPublic(), pl.getPublic());
	}
	

}
