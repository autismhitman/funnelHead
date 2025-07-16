package apis;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.Playlist;

public class PlaylistApi {
	
	@Step
	public static Response post(Playlist requestPlaylist) {
		
		return RestResource.post(Routes.USERS+"/"+ apis.GetUserId.getUserDetails()+Routes.PLAYLISTS, requestPlaylist);
	}
	@Step
	public static Response get(String playlistId) {
		
		return RestResource.get(Routes.PLAYLISTS+"/"+playlistId);
	}
	
	@Step
	public static Response put(String playlistId, Playlist playlist) {
		
		return RestResource.put(Routes.PLAYLISTS+"/"+ playlistId, playlist);
		
	}

}
