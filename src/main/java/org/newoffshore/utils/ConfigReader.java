package org.newoffshore.utils;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

public final class ConfigReader {

    private static final String DEFAULT_PROPERTIES_FILE = "application.properties";
    private static final Properties properties = new Properties();

    static {
        // 1) Load application.properties from classpath (src/main/resources)
        try (InputStream in = ConfigReader.class.getClassLoader()
                .getResourceAsStream(DEFAULT_PROPERTIES_FILE)) {

            if (in == null) {
                throw new IllegalStateException(
                        "Cannot find " + DEFAULT_PROPERTIES_FILE + " on classpath. " +
                                "Make sure it exists in src/main/resources/ so it is copied to target/classes."
                );
            }

            properties.load(in);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load " + DEFAULT_PROPERTIES_FILE, e);
        }
    }

    private ConfigReader() {}

    // ===== Generic accessors =====

    public static String get(String key) {
        String v = properties.getProperty(key);
        if (v == null) return null;
        return v.trim();
    }

    /**
     * Same as get(), but throws a clear error if missing/blank.
     * Use this for keys that are required for running flows.
     */
    public static String require(String key) {
        String v = get(key);
        if (v == null || v.isBlank()) {
            throw new IllegalStateException("Missing or blank config key: " + key + " in " + DEFAULT_PROPERTIES_FILE);
        }
        return v;
    }

    // ===== Your current methods (kept for backward compatibility) =====

    public static String getUrl() {
        // was: properties.getProperty("url")
        return require("url");
    }

    public static String getUrlOffer(String country) {
        String urlOffer = require("url_offer");   // expects template containing {country}
        return urlOffer.replace("{country}", Objects.requireNonNull(country, "country"));
    }

    // Keep your current method names to avoid changing other code.
    // (Consider renaming "Tọken" -> "Token" later for cleanliness.)
    public static String getCookiesAccessTọkenName() {
        return require("cookies.access_token.name");
    }

    public static String getCookiesAccessTọkenValue() {
        return require("cookies.access_token.value");
    }

    /**
     * Returns absolute file path for a resource.
     * NOTE: This works when resource is a real file on disk (dev/test).
     * If you package into a jar, some resources may not have a filesystem path.
     * Prefer getResourceAsStream(...) for reading resource contents.
     */
    public static String getResourceFilePath(String resourcePath) {
        try {
            URL url = ConfigReader.class.getClassLoader().getResource(resourcePath);
            if (url == null) {
                throw new IllegalStateException("Resource not found on classpath: " + resourcePath);
            }
            return Paths.get(url.toURI()).toFile().getAbsolutePath();
        } catch (Exception e) {
            throw new RuntimeException("Cannot load resource as file path: " + resourcePath, e);
        }
    }

    /**
     * Recommended way to read a resource (works both in IDE and inside jar).
     */
    public static InputStream getResourceAsStream(String resourcePath) {
        InputStream in = ConfigReader.class.getClassLoader().getResourceAsStream(resourcePath);
        if (in == null) {
            throw new IllegalStateException("Resource not found on classpath: " + resourcePath);
        }
        return in;
    }
}