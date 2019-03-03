package org.ds;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationPropertiesReader {

    private static Properties properties = new Properties();

    static {
        InputStream inputStream = ApplicationPropertiesReader.class.getResourceAsStream("/application.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {

        }
    }

    public static Properties getProperties() {
        return properties;
    }

    public static void setProperties(Properties properties) {
        ApplicationPropertiesReader.properties = properties;
    }

    public static String getProperty(String propertyName) {
        return (String) properties.get(propertyName);
    }

    public static void setProperty(String propertyName, String propertyValue) {
        properties.put(propertyName, propertyValue);
    }


}
