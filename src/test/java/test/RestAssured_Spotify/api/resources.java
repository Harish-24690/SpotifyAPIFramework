package test.RestAssured_Spotify.api;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import test.RestAssured_Spotify2.pojo.Playlist;

public class resources {
	
	public static Response post(Object payload,String accessToken,String path) {
		Response response= given().spec(SpecBuilder.getrequestSpecBuilder()).
		  body(payload)
		  .auth().oauth2(accessToken)     //.header("Authorization" ,"Bearer "+accessToken)
		  .when().post(path).
		  then().spec(SpecBuilder.getresponseSpecBuilder())
		  .extract().response();
		return response;
	}
	
	
	
	public static Response get(String accessToken,String path) {
		return given().spec(SpecBuilder.getrequestSpecBuilder())
				.auth().oauth2(accessToken)    //.header("Authorization" ,"Bearer "+accessToken)
				
		.when().get(path).
		then().spec(SpecBuilder.getresponseSpecBuilder())
		.extract().response();
	}
	
	public static Response put(Object payload ,String path,String accessToken) {
		
		 return given().spec(SpecBuilder.getrequestSpecBuilder()).
			body(payload)
			.auth().oauth2(accessToken)    //.header("Authorization" ,"Bearer "+accessToken)
			.when().put(path)
			.then().spec(SpecBuilder.getresponseSpecBuilder())
			.extract().response();
	}
	
	public static Response getaccess_token(HashMap<String,String>formparam) {
		Response response=  given().baseUri("https://accounts.spotify.com")
				  .formParams(formparam)
				  .contentType(ContentType.URLENC)
				  .log().all()
				  .when().post("/api/token")
				  .then().spec(SpecBuilder.getresponseSpecBuilder())
				  .extract().response();
				  if(response.statusCode()!=200) {
					  throw new RuntimeException("Abort!! token expired");
				  }
				  return response;
	}
	
	/*
	 * public static Response post(Object payload,String token,String path) {
	 * Response response= given().spec(SpecBuilder.getrequestSpecBuilder()).
	 * body(payload). header("Authorization" ,"Bearer "+token).
	 * when().post("users/31hykqopbuofnrzol2tujcau2l7u/playlists").
	 * then().spec(SpecBuilder.getresponseSpecBuilder()) .extract().response();
	 * return response;
	 * 
	 * }
	 */
	

}
