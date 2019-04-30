package sk.mishco.springboottutorial.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingService.class);

    @Value("${spring.application.name}")
    private String name;

    public String greet() {
        LOGGER.info("Creating greeting");
        String greeting = "Hello ";
        return greeting + name;
    }

}
