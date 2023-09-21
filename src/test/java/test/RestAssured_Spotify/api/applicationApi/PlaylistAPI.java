package test.RestAssured_Spotify.api.applicationApi;

import io.restassured.response.Response;
import test.RestAssured_Spotify.api.TokenManager;
import test.RestAssured_Spotify.api.resources;
import test.RestAssured_Spotify2.pojo.Playlist;

public class PlaylistAPI {
	//static String accessToken ="BQAxY4Rp8g5dcSRWArJEKAlUKNixnNmnk8voDbLR92lN-qu98StZrhKr6EwMviwbiIV1rD6W4jpytjzmkwK0k-aZU2H8wQ6SsaEDvkvFKjJkHRGH1qd2UCw14_XUfUun7yIUiDhgFDkZ3dtLmMfJukHAhQlVW20x2mqVAxI6kG7D6HZK3HyJytzvXL0CJvP_QslVJRvK-PMsnI5tevxExsJK-VArQH-rLlkYSkr39l6DSSqjE-vyEyeSJXcaG1158UBrIoEl_YEizbfU";
	
	public static Response post(Playlist requestPlaylist) {
		return resources.post(requestPlaylist, TokenManager.getToken(), "users/31hykqopbuofnrzol2tujcau2l7u/playlists");
		
		 
	}
	public static Response post(String token ,Playlist requestPlaylist) {
		return resources.post(requestPlaylist, token, "users/31hykqopbuofnrzol2tujcau2l7u/playlists");
		
		 
	}
	public static Response get(String playlistId) {
		return resources.get(TokenManager.getToken(), "playlists/"+playlistId);
		
	}
	
	public static Response put(Playlist requestPlaylist ,String playlistId) {
		return resources.put(requestPlaylist, "playlists/"+playlistId, TokenManager.getToken());
		 
	}

}
