package test.RestAssured_Spotify2.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Owner {
	
	private String display_name;
	private External_urls_owner external_urls;
	private String href;
	private String id;
	private String type;
	private String uri;
	
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	
	
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public External_urls_owner getExternal_urls() {
		return external_urls;
	}
	public void setExternal_urls(External_urls_owner external_urls) {
		this.external_urls = external_urls;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
	

}
