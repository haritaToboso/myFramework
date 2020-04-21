package config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigurationProperties {

    private Properties properties=new Properties();
	String path = System.getProperty("user.dir");
	private final String propertyFilePath= path +"\\src\\main\\java\\selenium\\myFramework\\config\\globalConfigurations.properties";
	
	//Method to get property value
	public String getProperties(String key)
	{
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			try {
				properties.load(reader);
				reader.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
	   	} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Property File is not found at " + propertyFilePath);
		} 
		
		String keyValue = properties.getProperty(key);
		if(key != null) return keyValue;
		else throw new RuntimeException(key +" not specified in the Configuration.properties file.");
	}

	//Method to set property 
	public void setProperties(String key,String value){

		try {
			OutputStream writer=new FileOutputStream(propertyFilePath);
		    properties.setProperty(key, value);
		    properties.store(writer,null);
			} 
			
	    catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Property File is not found at " + propertyFilePath);
		} 
		catch (IOException e) {
			e.printStackTrace();

	}
}
	
}
