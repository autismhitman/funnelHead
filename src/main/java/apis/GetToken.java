package apis;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetToken {
	 
	 
	public static String getAccessToken() {
		
		Map<String, String> map = new HashMap<>();
		map.put("client_id","5c352f4dce8649ec85e286008c0ec2b5" );
		map.put("client_secret","8db866a33e054ede8084c29282b66d24" );
		map.put("grant_type","refresh_token" );
		map.put("refresh_token","AQAPZZRJ9kmkD3B3A4ZbVq6O3Fc2sKPaduOePpuydFpKYap7hxxOxgj_nKxXs9MXEYg-PM-opusrsTPoy4u0FhnpmDpmvEo5Ij6trlH_f_aCU_3_a5TC-B0V8NyKgmuwKSo" );
		 
		
		Response response = given()
		  .baseUri("https://accounts.spotify.com/api")
		  .contentType(ContentType.URLENC)
		  .formParams(map)
		.when()
		  .post("/token")	
		.then().extract().response();
		
	     String accessToken =  response.path("access_token");
	     System.out.println("Token==> "+accessToken );
		return response.path("access_token");
		
		 
	}
	

}
