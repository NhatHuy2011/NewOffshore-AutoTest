package org.newoffshore.utils;

import org.newoffshore.constant.Constant;

import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Objects;
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

    public static String getUrlOffer(String country){
        String urlOffer = properties.getProperty("url_offer");
        return urlOffer.replace("{country}", country);
    }

    public static String getCookiesAccessTọkenName(){
        return properties.getProperty("cookies.access_token.name");
    }

    public static String getCookiesAccessTọkenValue(){
        return properties.getProperty("cookies.access_token.value");
    }

    public static String getResourceFilePath(String resourcePath) {
        try {
            return Paths.get(
                    Objects.requireNonNull(
                            ClassLoader.getSystemResource(resourcePath)
                    ).toURI()
            ).toFile().getAbsolutePath();
        } catch (Exception e) {
            throw new RuntimeException("Cannot load resource: " + resourcePath, e);
        }
    }

}
