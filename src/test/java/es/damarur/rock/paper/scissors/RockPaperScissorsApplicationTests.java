package es.damarur.rock.paper.scissors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(
	classes = {RockPaperScissorsApplication.class},
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class RockPaperScissorsApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
		ResponseEntity<Void> health = restTemplate.getForEntity("/actuator/health", Void.class);
		assertThat(health.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
