package com.itacademy.utils;

import com.itacademy.exception.PropertyFileException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager implements Constants {
    public static String getProperties(String key) {
        try (InputStream input = new FileInputStream(PROPERTY_FILE_PATH)) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty(key);
        } catch (IOException exp) {
            throw new PropertyFileException(exp.getMessage());
        }
    }
}
