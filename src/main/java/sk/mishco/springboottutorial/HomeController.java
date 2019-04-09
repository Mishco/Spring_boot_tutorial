package sk.mishco.springboottutorial;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sk.mishco.springboottutorial.services.GreetingService;

@Controller
public class HomeController {

    private final GreetingService service;

    public HomeController(GreetingService service) {
        this.service = service;
    }

    @GetMapping("/")
    public @ResponseBody
    String greeting() {
        return service.greet();
    }
}
