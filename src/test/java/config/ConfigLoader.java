package config;

import java.io.IOException;
import java.util.Properties;

import test.RestAssured_Spotify.api.Utils.PropertyUtils;

public class ConfigLoader {
	private static Properties properties;
	private static  ConfigLoader configLoader;
	
	private ConfigLoader() throws IOException {
		
 properties=PropertyUtils.propertyLoader(System.getProperty("user.dir")+"//src//test//java//config//config.properties");
	}

	public static ConfigLoader getInstance() throws IOException {
		if(configLoader==null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}
	
	public  String getClientId() {
		String clientid=properties.getProperty("client_id");
		if(clientid!=null) return clientid;
		else throw new RuntimeException("Clientid is not declared in Config.properties file");
		
	}
	public String getClientSecret() {
		String clientsecret=properties.getProperty("client_secret");
		if(clientsecret!=null) return clientsecret;
		else throw new RuntimeException("Clientsecret is not declared in Config.properties file");
		
	}
	public  String getGrantType() {
		String grantType=properties.getProperty("grant_type");
		if(grantType!=null) return grantType;
		else throw new RuntimeException("grantType is not declared in Config.properties file");
		
	}
	public  String getRefreshToken() {
		String refreshToken=properties.getProperty("refresh_token");
		if(refreshToken!=null) return refreshToken;
		else throw new RuntimeException("token is not declared in Config.properties file");
		
	}
}
