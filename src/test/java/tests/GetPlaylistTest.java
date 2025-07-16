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
import utils.RestUtils;

public class GetPlaylistTest {
	
	
	
	@Description("validates whether the playlist is fetched by providing the Id")
	@Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-121")
    @TmsLink("TMS-123")
	@Test
	
	public void fetchPlaylists(ITestContext context) {	 
	
		String playlistId ="11UfDVH79vtWLFFkhEFbTi";   //(String) context.getAttribute("playlist_id");
		System.out.println("Fetched: "+ playlistId);
		
		Response response = PlaylistApi.get(playlistId);
		RestUtils.assertStatusCode(response.statusCode(), StatusCode.CODE_200);	
		 
		
	  /*   Response response=	given(SpecBuilder.requestSpecBuilder()) 	
		                   .when()
			                  .get("/playlists/"+playlistId)	
			               .then().spec(SpecBuilder.responseSpecBuilder()).assertThat().statusCode(200).extract().response();

         String playlist_id = response.path("id");
		System.out.println(playlist_id );
		*/
	}
	

}
