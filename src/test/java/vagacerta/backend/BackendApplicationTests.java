package vagacerta.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = BackendApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class BackendApplicationTests {

	@Test
	void contextLoads() {
	}

}
