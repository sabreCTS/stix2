package eu.csaware.stix2.test.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 */
public class TestUtil {
    private static final String RESOURCE_BASE_PATH = "src/test/resources/";
    private static final String INTEGRATION_BASE_PATH = "src/test/resources/integration/";
    private static final String SERIALIZED_BASE_PATH = "out/test/serialized/";

    public static String readResourceFile(String path) throws IOException {
        return readFile(RESOURCE_BASE_PATH + path);
    }

    /**
     * Prepare a string containing JSON for comparison.
     */
    public static String sanitizeJson(String content) throws IOException {
        return content.replace("\r", "");
    }

    public static Path writeSerializedOutputFile(String path, String content) throws IOException {
        ensureDirectoryExists(SERIALIZED_BASE_PATH);
        ensureDirectoryExists(SERIALIZED_BASE_PATH + path.substring(0, path.lastIndexOf("/")));
        return writeFile(SERIALIZED_BASE_PATH + path, content);
    }

    public static Path getSerializedOutputPath(String filename) throws IOException {
        ensureDirectoryExists(SERIALIZED_BASE_PATH);
        return Paths.get(SERIALIZED_BASE_PATH + filename);
    }

    public static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    public static Path writeFile(String path, String content) throws IOException {
        return Files.write(Paths.get(path), content.getBytes());
    }

    private static File ensureDirectoryExists(String path) {
        File base = new File(path);
        base.mkdirs();
        return base;
    }

}
