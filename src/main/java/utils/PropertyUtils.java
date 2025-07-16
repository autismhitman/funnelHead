package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
	


	public static Properties propertyLoader(String filePath) {
		
		Properties prop = new Properties();
		FileReader reader;
		
		try{
			reader = new FileReader(filePath);
			 prop.load(reader);
			 reader.close();
		  }
			 
		 catch (IOException e) {
			
			e.printStackTrace();
			 throw new RuntimeException("failed to load properties file "+ filePath);
		}
		return prop;
		
		
	}
	
	

}
