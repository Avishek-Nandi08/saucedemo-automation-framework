package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    
    private static Properties properties;

    // This static block runs once when the class is loaded into memory
    static {
        try {
            // Path to your properties file
            String filePath = "src/test/resources/config.properties";
            FileInputStream inputStream = new FileInputStream(filePath);
            
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration file not found!");
        }
    }

    // Method to fetch the data
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}