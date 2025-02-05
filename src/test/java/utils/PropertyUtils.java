package utils;

import org.openqa.selenium.devtools.v85.io.IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    public static Properties propertyLoader(String filePath){

        Properties properties = new Properties();
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(filePath));
            try{
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException("failed to load properties file"+filePath);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("properties file not found "+filePath);
        }
        return properties;
    }
}
