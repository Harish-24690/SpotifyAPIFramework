package test.RestAssured_Spotify.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
	
	public static RequestSpecification getrequestSpecBuilder() {
		
     return new RequestSpecBuilder()
		.setBaseUri(System.getProperty("BASE_URI"))   //System.getProperty("BaseURI	")    //"https://api.spotify.com/""
		.setBasePath(Route.BASEPATH)                      // Basepath coming form Route;
		.setContentType(ContentType.JSON)
				.log(LogDetail.ALL).build();
		

		
	}
	
	public static ResponseSpecification getresponseSpecBuilder() {
		
		return new ResponseSpecBuilder().
		//.expectContentType(ContentType.JSON)
		log(LogDetail.ALL).build();
		
		
		
	}

}


/*
 * RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
 * 
 * requestSpecBuilder.setBaseUri("https://api.spotify.com/") .setBasePath("/v1")
 * .addHeader("Authorization",
 * "Bearer BQC4L9bcTDnLbLlb0FLwf4VZ3ukertyrU9qP5gy-6exE_rLZq8t4ONIm0o150dYgikYOol1yM3sBEGrDbHT6xZMkRQnD4BQNNbb5RFBNDBQQBaH5A02TRAwUPvId1phon8_rNU5I20HpFHhWt25V2yaM_SgEz2E6Bl9SeNLjh1fdVd_XbHQqPRjqqPXNEUWmco0bH1UZsaiVBA6ZmcBRByCHNWUEzh7zL4ok6L8NVuEf60JJbfTgmfk7lXC8ZpqjEP8X0Z7-RF-QlCHj"
 * ) .setContentType(ContentType.JSON) .log(LogDetail.ALL); requestSpecification
 * = requestSpecBuilder.build();
 * 
 * ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
 * responseSpecBuilder //.expectContentType(ContentType.JSON)
 * .log(LogDetail.ALL); responseSpecification = responseSpecBuilder.build();
 */

