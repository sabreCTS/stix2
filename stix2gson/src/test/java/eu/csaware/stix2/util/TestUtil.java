package eu.csaware.stix2.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 */
public class TestUtil {

    public static String readResourceFile(String path) throws IOException {
        return readFile("src/test/resources/eu/csaware/stix2/" + path);
    }

    public static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }

}
