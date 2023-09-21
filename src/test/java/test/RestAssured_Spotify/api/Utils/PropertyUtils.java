package test.RestAssured_Spotify.api.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
	
	public static Properties propertyLoader(String filepath) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(filepath);
		prop.load(fis);
		return prop;
	}

}
