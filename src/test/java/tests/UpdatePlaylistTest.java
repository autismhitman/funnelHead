package tests;

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

public class UpdatePlaylistTest {
	
	
	@Description("validates whether the playlist can be modified by providing the Id")
	@Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-120")
    @TmsLink("TMS-121")
	@Test
	public void modifyPlaylists(ITestContext context) {
		
		Playlist pl = new Playlist().setName("Tesla New").setDescription("Elon musk New").setPublic(false);
		
		//Response response = PlaylistApi.put((String) context.getAttribute("playlist_id"), pl);
		Response response = PlaylistApi.put("11UfDVH79vtWLFFkhEFbTi", pl);	
		RestUtils.assertStatusCode(response.statusCode(), StatusCode.CODE_200);	
		
		
		/*              given(SpecBuilder.requestSpecBuilder()) 
										.body(pl)
									.when()
									    .put("/playlists/"+ (String) context.getAttribute("playlist_id"))	
									.then().spec(SpecBuilder.responseSpecBuilder()).assertThat().statusCode(200);
         */
	 
	}
	

}
