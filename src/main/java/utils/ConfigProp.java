package utils;

import java.util.Properties;

public class ConfigProp {
	
	private final Properties properties;
	private static ConfigProp configProp= null;
	
	private ConfigProp() {
		properties = PropertyUtils.propertyLoader("./src/test/resources/config.properties");
	}
	
	public static ConfigProp getInstance() {
		
		if(configProp==null) {
			configProp= new ConfigProp();
		}
		return configProp;
	}
	
	public String getClientId(){
		
		String prop = properties.getProperty("client_id");
		if(prop != null) return prop;
        else throw new RuntimeException("property client_id is not specified in the config.properties file");
		
	}
	
   public String getClientSecret(){
		
		String prop = properties.getProperty("client_secret");
		if(prop != null) return prop;
        else throw new RuntimeException("property client_secret is not specified in the config.properties file");
		
	}
   
   public String getGrantType(){
		
		String prop = properties.getProperty("grant_type");
		if(prop != null) return prop;
        else throw new RuntimeException("property grant_type is not specified in the config.properties file");
		
	}
   
   public String getRefreshToken(){
		
		String prop = properties.getProperty("refresh_token");
		if(prop != null) return prop;
        else throw new RuntimeException("property refresh_token is not specified in the config.properties file");
		
	}

}
