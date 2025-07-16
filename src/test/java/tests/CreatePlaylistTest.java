package tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import apis.PlaylistApi;
import enums.StatusCode;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import io.restassured.response.Response;
import pojo.Playlist;
import utils.RestUtils;

public class CreatePlaylistTest {
	
	@Description("validates whether the playlist is created when valid data is provided")
	@Link(name = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
	@Test
	public void createPlaylists(ITestContext context) {
		
		Playlist pl = RestUtils.playlistData("Tesla", "Elon musk", false);
		Response response = PlaylistApi.post(pl);
		
		RestUtils.assertStatusCode(response.statusCode(), StatusCode.CODE_201);	
		
		Playlist responsePlaylist = response.as(Playlist.class);
		
		String playlist_id = responsePlaylist.getId();
        context.setAttribute("playlist_id", playlist_id);
		System.out.println("playlist_id====> " + playlist_id );
		 
		RestUtils.assertPlaylistEqual(responsePlaylist, pl);
	 	
		/*Playlist responsePlaylist=	given(SpecBuilder.requestSpecBuilder())
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
		*/
	}
	

}
