package test.RestAssured_Spotify.api;

public enum StatusCode {
	
	CODE_200(200,""),
	CODE_201(201,""),
	CODE_400(400,"Missing required field"),
	CODE_401(401,"Invalid access_token");
	
	public int code;
	public String message;

	StatusCode(int code, String msg) {
		this.code=code;
		this.message=msg;
	}
	

}
