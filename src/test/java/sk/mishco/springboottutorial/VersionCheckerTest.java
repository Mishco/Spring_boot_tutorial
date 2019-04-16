package sk.mishco.springboottutorial;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

class VersionCheckerTest {

    @Test
    void getSpringVersion() {
        String springVersion = SpringVersion.getVersion();

        assertTrue(VersionChecker.getSpringVersion().contains(Objects.requireNonNull(springVersion)));
    }

    @Test
    void getSpringBootVersion() {
        String springBootVersion = SpringBootVersion.getVersion();

        assertTrue(VersionChecker.getSpringBootVersion().contains(springBootVersion));
    }
}