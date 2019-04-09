package sk.mishco.springboottutorial;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sk.mishco.springboottutorial.controller.HomeController;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class ControllerTest {

    @Autowired
    private HomeController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }
}

