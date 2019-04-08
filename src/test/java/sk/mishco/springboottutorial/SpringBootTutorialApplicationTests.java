package sk.mishco.springboottutorial;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SpringBootTutorialApplicationTests {

    @Test
    void contextLoads() {
        /*
          Because of spring boot test, we only need empty test
         */
        assertTrue(true);
    }

    // Test class added ONLY to cover main() invocation not covered by application tests.

    @Test
    void main() {
        SpringBootTutorialApplication.main(new String[]{});
    }

}
