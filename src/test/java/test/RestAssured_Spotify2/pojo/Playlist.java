package test.RestAssured_Spotify2.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

//@Data
//@Jacksonized
//@Builder 
//@Value
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Playlist {
	
	private Boolean collaborative;
	private String description;
	private ExternalURL external_urls;
	private Followers followers;
	private String href;
	private String id;
	private List<Object> images;
	private String name;
	private Owner owner;
	private String primary_color;
	@JsonProperty("public")
	private Boolean _public;
	private String snapshot_id;
	private Tracks tracks;
	private String type;
    private String uri;
   
	
	

}
