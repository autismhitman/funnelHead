package utils;

import org.testng.Assert;

import enums.StatusCode;
import io.qameta.allure.*;
import pojo.Playlist;
public class RestUtils {
	
	@Step
	public static Playlist playlistData(String name, String description, boolean _public ) {
		
		return  new Playlist().setName(name).setDescription(description).setPublic(_public);
	}
	
	@Step
	public static void  assertStatusCode (int actual, StatusCode expected) {
		
		  Assert.assertEquals(actual, expected.getCode());
	}
	
	@Step
	public static void assertPlaylistEqual (Playlist responsePlaylist, Playlist pl) {
		
		Assert.assertEquals(responsePlaylist.getName(), pl.getName());
		Assert.assertEquals(responsePlaylist.getDescription(), pl.getDescription());
		Assert.assertEquals(responsePlaylist.getPublic(), pl.getPublic());
	}

}
