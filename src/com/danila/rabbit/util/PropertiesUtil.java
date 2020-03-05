package com.danila.rabbit.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {

    private static Properties properties;

    static {
        loadProperties();
    }

    private PropertiesUtil() {
    }

    private static void loadProperties() {
        properties = new Properties();
        try {
            InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}

