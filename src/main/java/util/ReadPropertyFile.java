package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
    Properties properties;
    FileInputStream fileInputStream;
    private static String defaultFilePath = System.getProperty("user.dir") + "/src/main/resources/config.properties";

    public void loadPropertyFile() {
        properties = new Properties();
        try {
            fileInputStream = new FileInputStream(defaultFilePath);
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProperty(String propertyKey) {
        if (properties == null) {
            loadPropertyFile();
        }

        return properties.getProperty(propertyKey);
    }
}