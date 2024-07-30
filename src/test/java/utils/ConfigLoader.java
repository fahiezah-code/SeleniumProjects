package utils;

import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;
    private static ConfigLoader configLoader;//static ->once assign the value to it, the value will be return

    private ConfigLoader(){ // we don't want any other class to create instance of this class
        // to load the properties
        properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");


    }

   public static ConfigLoader getInstance(){
       if(configLoader == null){
           configLoader = new ConfigLoader();
       }
       return configLoader;
   }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("property base url is not specified in the properties file");
    }
}
