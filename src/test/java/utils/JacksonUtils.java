package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import objects.Product;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {
/*
   public static <T>T deserializeJson(String fileName,Class<T>T) throws IOException {
    InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(is,T);
    }

 */

    public static <T> T deserializeJson(String fileName,Class<T>T) throws IOException {
        // read the file
        InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(fileName);
        // map the file to desired object
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(is,T);
    }
}
