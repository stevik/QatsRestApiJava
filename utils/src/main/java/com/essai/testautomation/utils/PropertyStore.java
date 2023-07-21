package com.essai.testautomation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertyStore {

    private static final Properties APP_PROPS = new Properties();

    private PropertyStore() {

    }


    public static String getProperty(String key, String fileName) {
        if (key == null || fileName == null) {
            return null;
        }
        loadPropertiesFromFile(fileName);
        return APP_PROPS.getProperty(key);
    }

    private static void loadPropertiesFromFile(String fileName) {
        String absolutePath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + fileName;
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(absolutePath))) {
            APP_PROPS.load(inputStreamReader);

        } catch (IOException e) {
            throw new IllegalArgumentException("Error during loading properties", e);
        }
    }
}
