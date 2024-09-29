package org.automation.utilities;

import org.automation.utilities.exceptions.KeyNotFoundException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    private static final String testConfigFilePath = "src/main/resources/testConfig.properties";
    private static Properties properties;

    public static String get(String key) {
        if (properties == null)
            initiateProperties();

        if (!properties.containsKey(key))
            throw new KeyNotFoundException(key);

        return properties.getProperty(key);
    }

    private static void initiateProperties() {

        try {
            File propertiesFile = new File(testConfigFilePath);
            FileInputStream fileInputStream = new FileInputStream(propertiesFile);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
