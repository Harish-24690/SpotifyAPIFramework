package test.RestAssured_Spotify.api.Utils;

import com.github.javafaker.Faker;

public class FakerUtils {
	
	public static String generateName() {
		Faker faker = new Faker();
		String PlaylistName="Playlist" + faker.regexify("[A-Za-z0-9 ,_-]{10}");
		return PlaylistName;
	}
	
	public static String generateDescription() {
		Faker faker = new Faker();
		return "Description"+faker.regexify("[A-Za-z0-9_@./#&+-]{50}");
	}

}
