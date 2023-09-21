package test.RestAssured_Spotify.api;

import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;

import config.ConfigLoader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import test.RestAssured_Spotify.api.Utils.PropertyUtils;

import static io.restassured.RestAssured.given;
public class TokenManager {
	
	static String access_token;
	static Instant expires_time;
	
	public static String getToken() {
		try {
			Response response=renewToken();
			access_token=response.path("access_token");
			int expiresDurationInSeconds=response.path("expires_in");
			expires_time= Instant.now().plusSeconds(expiresDurationInSeconds);
			if(access_token==null || Instant.now().isAfter(expires_time)) {
				System.out.println("Renewing token");
				
			}
			
		}catch(Exception e) {
			throw new RuntimeException("Failed to get token");
		}
		return access_token;
	}
	
	
	public static Response renewToken() throws IOException {
		
		HashMap<String,String> formparam = new HashMap<String,String>();
		  formparam.put("client_id",ConfigLoader.getInstance().getClientId());
		  formparam.put("client_secret", ConfigLoader.getInstance().getClientSecret());
		  formparam.put("grant_type", ConfigLoader.getInstance().getGrantType());
		  formparam.put("refresh_token", ConfigLoader.getInstance().getRefreshToken());
		  
		Response response =resources.getaccess_token(formparam);
		return response;
	}

}
