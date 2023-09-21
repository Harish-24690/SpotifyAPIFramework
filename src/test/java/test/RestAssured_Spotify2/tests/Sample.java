package test.RestAssured_Spotify2.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import test.RestAssured_Spotify.api.SpecBuilder;
import test.RestAssured_Spotify2.pojo.Playlist;

public class Sample {
	
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	// String
	// accessToken="BQCuNYnfjVAdh6MfMALMrdwzyjIG_mAfOvQJyEWHXbIGm6Jzry6G8xq7ky1WZmNXl2il6G2JmEH8epfOVjRRqRVMibc1tSHKoFTsT2oK3u3dGsz9t6z9MPC9XxGKaJZ-itS1jHQJ1RKQBQPtrJf78Q8tnlBAd4zWUksXqevLMArMn9yMaH7v7ZIXpKxrtTFfURmLniH0gJHTlyP8f0zbiKg9jxzpm5suMvYpwphyGDwNMeb-cgI70Di0Ept_cSaTUeMTfhKUa103JOIc";

	@BeforeClass
	public void beforeClass() {

		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

		requestSpecBuilder.setBaseUri("https://api.spotify.com/")
		.setBasePath("/v1")
		.addHeader("Authorization",
				"Bearer BQC4L9bcTDnLbLlb0FLwf4VZ3ukertyrU9qP5gy-6exE_rLZq8t4ONIm0o150dYgikYOol1yM3sBEGrDbHT6xZMkRQnD4BQNNbb5RFBNDBQQBaH5A02TRAwUPvId1phon8_rNU5I20HpFHhWt25V2yaM_SgEz2E6Bl9SeNLjh1fdVd_XbHQqPRjqqPXNEUWmco0bH1UZsaiVBA6ZmcBRByCHNWUEzh7zL4ok6L8NVuEf60JJbfTgmfk7lXC8ZpqjEP8X0Z7-RF-QlCHj")
				.setContentType(ContentType.JSON)
				.log(LogDetail.ALL);
		requestSpecification = requestSpecBuilder.build();

		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
		responseSpecBuilder
		//.expectContentType(ContentType.JSON)
		.log(LogDetail.ALL);
		responseSpecification = responseSpecBuilder.build();

	}
	
	Playlist playlistResponse =given().spec(SpecBuilder.getrequestSpecBuilder()).
			  //body(requestPlaylist). 
			 when().post("users/31hykqopbuofnrzol2tujcau2l7u/playlists").
			  then().spec(SpecBuilder.getresponseSpecBuilder()).
			  assertThat().
			  statusCode(201)
			  .extract().response().as(Playlist.class);
			  //assertThat(requestPlaylist.getName(),equalTo(playlistResponse.getName()));
			  //assertThat(requestPlaylist.getDescription(),equalTo(playlistResponse.getDescription()));
			  //assertThat(requestPlaylist.get_public(),equalTo(playlistResponse.get_public()));  

	
				/*
				 * Playlist responsePlaylist=given().spec(SpecBuilder.getrequestSpecBuilder())
				 * .when().get("playlists/6qgrzGOvLh31k8Sj4gublv").
				 * then().spec(SpecBuilder.getresponseSpecBuilder()) .assertThat().
				 * statusCode(200). contentType(ContentType.JSON).
				 * extract().response().as(Playlist.class);
				 */
				/*
				 * given().spec(SpecBuilder.getrequestSpecBuilder()). body(requestPlaylist)
				 * .when().put("playlists/6qgrzGOvLh31k8Sj4gublv")
				 * .then().spec(SpecBuilder.getresponseSpecBuilder())
				 * .assertThat().statusCode(200);
				 */
	}

	/*
	 * Response response= given().spec(SpecBuilder.getrequestSpecBuilder()).
	 * body(requestPlaylist) .header("Authorization" ,"Bearer "+accessToken).
	 * when().post("users/31hykqopbuofnrzol2tujcau2l7u/playlists").
	 * then().spec(SpecBuilder.getresponseSpecBuilder()) .extract().response();
	 * return response;
	 */

	/*
	 * return given().spec(SpecBuilder.getrequestSpecBuilder())
	 * .header("Authorization" ,"Bearer "+accessToken)
	 * .when().get("playlists/"+playlistId).
	 * then().spec(SpecBuilder.getresponseSpecBuilder()) .extract().response();
	 */

	/*
	 * return given().spec(SpecBuilder.getrequestSpecBuilder()).
	 * body(requestPlaylist) .header("Authorization" ,"Bearer "+accessToken)
	 * .when().put("playlists/"+playlistId)
	 * .then().spec(SpecBuilder.getresponseSpecBuilder()) .extract().response();
	 */
	/*
	 * Response response= given().spec(SpecBuilder.getrequestSpecBuilder()).
	 * body(requestPlaylist). header("Authorization" ,"Bearer "+token).
	 * when().post("users/31hykqopbuofnrzol2tujcau2l7u/playlists").
	 * then().spec(SpecBuilder.getresponseSpecBuilder()) .extract().response();
	 * return response;
	 */