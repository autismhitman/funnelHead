package apis;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import utils.ConfigProp;

public class TokenManager {
	 
	private static String access_token;
	private static Instant expiry_time;
	
	@Step
	public synchronized static String getToken() {
		
		try {
			
			if(access_token==null|| Instant.now().isAfter(expiry_time)) {
				
				System.out.println("Renewing Token");
				Response response = getAccessToken();
				access_token = response.path("access_token");
				int expiryDurationInSeconds = response.path("expires_in");
				expiry_time = Instant.now().plusSeconds(expiryDurationInSeconds-300);
			}
			else {
				
				 System.out.println("Token is good to use");
			}
		} catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("ABORT!!! Failed to get token");
        }
        return access_token;
	}
	
	
	
	
	public static Response getAccessToken() {
		
		Map<String, String> map = new HashMap<>();
		map.put("client_id",ConfigProp.getInstance().getClientId());
		map.put("client_secret",ConfigProp.getInstance().getClientSecret());
		map.put("grant_type",ConfigProp.getInstance().getGrantType());
		map.put("refresh_token",ConfigProp.getInstance().getRefreshToken());
		 
		
		Response response =  RestResource.post(map);
		
		if(response.statusCode()!=200) {
			throw new RuntimeException("Abort! Renew token failed!!!");
		}
				
	      
		return response ;
		
		 
	}
	

}
