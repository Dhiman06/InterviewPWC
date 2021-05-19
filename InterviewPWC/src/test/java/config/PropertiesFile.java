package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import TripTest.MakeATrip;

public class PropertiesFile {

	public static void main(String[] args) {
		getProperties();

	}
	
	public static void getProperties() {
		
		try {
			String projectPath =System.getProperty("user.dir");
			InputStream input = new FileInputStream(projectPath+"/src/test/java/config/config.properties");
			Properties prop = new Properties();
			prop.load(input);
			MakeATrip.urlAddress=prop.getProperty("url");
			MakeATrip.fromCity = prop.getProperty("fromCity");
			MakeATrip.toCity = prop.getProperty("toCity");
			//System.out.println(MakeATrip.urlAddress);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

}
