package sk.mishco.springboottutorial.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Value("${spring.application.name}")
    private String name;

    public String greet() {
        String greeting = "Hello ";
        return greeting + name;
    }
}
