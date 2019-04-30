package sk.mishco.springboottutorial;

import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;

class VersionChecker {

    private VersionChecker() {
    }
    static String getSpringVersion() {
        return "Spring version: " + SpringVersion.getVersion();
    }

    static String getSpringBootVersion() {
        return "SpringBoot version: " + SpringBootVersion.getVersion();
    }
}
