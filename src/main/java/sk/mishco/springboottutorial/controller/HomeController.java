package sk.mishco.springboottutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sk.mishco.springboottutorial.services.GreetingService;

@Controller
public class HomeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    private final GreetingService service;

    public HomeController(GreetingService service) {
        this.service = service;
        LOGGER.info("Home Controller successfully init");
    }

    @GetMapping("/")
    public @ResponseBody
    String greeting() {
        LOGGER.info("'/' called success");
        return service.greet();
    }
}
