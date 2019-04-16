package sk.mishco.springboottutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTutorialApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootTutorialApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTutorialApplication.class, args);
        LOGGER.info(VersionChecker.getSpringVersion());
        LOGGER.info(VersionChecker.getSpringBootVersion());
    }

}
