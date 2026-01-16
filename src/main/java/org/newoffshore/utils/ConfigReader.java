package org.newoffshore.utils;

import org.newoffshore.constant.Constant;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(Constant.APPLICATION_PATH)) {
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUrl(){
        return properties.getProperty("url");
    }

    public static String getUrlOffer(){
        return properties.getProperty("url_offer");
    }

    public static String getCookiesAccessTọkenName(){
        return properties.getProperty("cookies.access_token.name");
    }

    public static String getCookiesAccessTọkenValue(){
        return properties.getProperty("cookies.access_token.value");
    }
}
