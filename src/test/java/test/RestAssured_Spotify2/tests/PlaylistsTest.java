package test.RestAssured_Spotify2.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.restassured.response.Response;
import test.RestAssured_Spotify.api.applicationApi.PlaylistAPI;
import test.RestAssured_Spotify2.pojo.Errors;
import test.RestAssured_Spotify2.pojo.Playlist;
import test.RestAssured_Spotify.api.StatusCode;
import test.RestAssured_Spotify.api.Utils.FakerUtils;

@Epic("Spotify Oauth2.0")
@Feature("PlaylistAPI")
public class PlaylistsTest {

	String playlistId = "6qgrzGOvLh31k8Sj4gublv"; 
	
   public Playlist getRequestPayload(String name,String description,boolean _public) {
	/*
	 * Playlist requestPlaylist = new Playlist() .setDescription(description)
	 * .setName(name) .set_public(_public); return requestPlaylist; }
	 */
	   Playlist requestPlaylist = new Playlist();
	      requestPlaylist.setName(name);
	      requestPlaylist.setDescription(description);
	      requestPlaylist.set_public(_public);
	      return requestPlaylist;
   }
	@Description("This a Test that helps us to create a playlist in Spotify")
	@Link("https://spotify.com")
	@Issue("1234")
	@TmsLink("test-01")
	@Story("Create a Playlist")
	 @Test(description="Create a Playlist")
	 public void createPlaylistTest() { 
		
		 Playlist requestPlaylist=getRequestPayload(FakerUtils.generateName(), FakerUtils.generateDescription(), false);
		 Response response=PlaylistAPI.post(requestPlaylist);
		 assertThat(response.statusCode(),equalTo(201));     //equalTo(201)
         assertStatusCode(response.statusCode(),StatusCode.CODE_201.code);
		 
	  Playlist responseplaylist=response.as(Playlist.class);
	  assertThat(requestPlaylist.getName(),equalTo(responseplaylist.getName()));
	  assertThat(requestPlaylist.getDescription(),equalTo(responseplaylist.getDescription()));
	  assertThat(requestPlaylist.get_public(),equalTo(responseplaylist.get_public()));
	 
	 }
	 

	
	@Test
	public void getPlaylistTest() {
		
		
		Response response=PlaylistAPI.get(playlistId);
		        assertThat(response.statusCode(),equalTo(200));
		        //assertThat(response.getContentType(), hasContentType("application/json"));
		        
		        Playlist responsePlaylist= response.as(Playlist.class);
		        assertThat(responsePlaylist.getName(),equalTo("Harish Playlist2"));
				assertThat(responsePlaylist.getDescription(),equalTo("Newly playlist description2"));
				assertThat(responsePlaylist.get_public(), equalTo(false));
      
	
		
		
		
	}
	
	@Test
	public void updatePlaylistTest() {
		
		Playlist requestPlaylist=getRequestPayload("Harish Playlist2", "Newly playlist description2", false);
		Response response=PlaylistAPI.put(requestPlaylist, playlistId);
		assertThat(response.statusCode(),equalTo(200));
        
	}
	
	//Negative Scenarios
	@Test
	 public void createPlaylistWithoutNameTest() { 
	
	Playlist requestPlaylist=getRequestPayload("", FakerUtils.generateDescription(), false);
	
	Response response=PlaylistAPI.post(requestPlaylist);
	Errors responseError=response.as(Errors.class);
	 
	 assertThat(responseError.getError().getStatus(),equalTo(400));
	 assertThat(responseError.getError().getMessage(),equalTo("Missing required field: name"));
	
	 }
	
	public void assertStatusCode(int actualStatusCode,int expectedStatusCode) {
		assertThat(actualStatusCode,equalTo(expectedStatusCode));;
	}
	
	
	
}
