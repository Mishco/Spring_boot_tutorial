package sk.mishco.springboottutorial;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import sk.mishco.springboottutorial.services.GreetingService;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private GreetingService greetingService;

    @Test
    void greetingShouldReturnDefaultMessage() {
        assertTrue(this.restTemplate.getForObject("http://localhost:" + port + "/",
                String.class).contains(greetingService.greet()));
    }

}
