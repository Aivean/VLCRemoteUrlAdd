package com.aivean.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author <a href="mailto:ivan.zaytsev@webamg.com">Ivan Zaytsev</a>
 *         2014-02-01
 */
public class Config {

    private static final String BUNDLED_PROPERTIES_NAME = "/config.properties";
    private static final String EXTERNAL_PROPERTIES_NAME = "config.properties";

    private static final Properties PROPERTIES = loadExternalProperties(loadBundledProperties());

    public static final int PORT = getPropertyAsInt("port");
    public static final String SOCKET = getProperty("socket");

    public static String getProperty(String name) {
        return PROPERTIES.getProperty(name);
    }

    public static int getPropertyAsInt(String name) {
        return Integer.parseInt(PROPERTIES.getProperty(name));
    }

    private static Properties loadBundledProperties() {
        return loadProperties(BUNDLED_PROPERTIES_NAME, Config.class.getResourceAsStream(BUNDLED_PROPERTIES_NAME), null);
    }

    private static Properties loadExternalProperties(Properties defaults) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(EXTERNAL_PROPERTIES_NAME);
        } catch (Exception e) {
            fileInputStream = null;
        }
        return loadProperties(EXTERNAL_PROPERTIES_NAME, fileInputStream, defaults);
    }

    private static Properties loadProperties(String name, InputStream is, Properties defaults) {
        try {
            return readProperties(is, defaults);
        } catch (Exception e) {
            System.err.println("Can't load properties " + name);
            e.printStackTrace();
            return defaults;
        }
    }

    private static Properties readProperties(InputStream is, Properties defaults) throws IOException {
        if (is == null) {
            System.err.println("Can't find properties file: " + BUNDLED_PROPERTIES_NAME);
            return defaults;
        }
        try {
            Properties properties;
            if (defaults == null) {
                properties = new Properties();
            } else {
                properties = new Properties(defaults);
            }
            properties.load(is);

            return properties;
        } finally {
            is.close();
        }
    }
}
