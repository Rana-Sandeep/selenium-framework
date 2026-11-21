package com.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Could not read config.properties", e);
        }
    }

    public static String get(String key) {
        String fromCommandLine = System.getProperty(key);
        if (fromCommandLine != null) {
            return fromCommandLine;
        }
        return properties.getProperty(key);
    }
}