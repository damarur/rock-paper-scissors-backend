package es.damarur.rock.paper.scissors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import es.damarur.rock.paper.scissors.config.ApiKeyFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest(
	classes = {RockPaperScissorsApplication.class},
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("test")
class RockPaperScissorsApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@MockitoBean
	private ApiKeyFilter apiKeyFilter;

	@Test
	void contextLoads() {
		ResponseEntity<Void> health = restTemplate.getForEntity("/actuator/health", Void.class);
		assertThat(health.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
