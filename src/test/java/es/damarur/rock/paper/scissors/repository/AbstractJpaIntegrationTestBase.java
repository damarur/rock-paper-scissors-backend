package es.damarur.rock.paper.scissors.repository;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

@ActiveProfiles("it")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public abstract class AbstractJpaIntegrationTestBase {

	public static final PostgreSQLContainer<?> POSTGRE_SQL_CONTAINER;

	static {
		POSTGRE_SQL_CONTAINER = new PostgreSQLContainer<>("postgres:17-alpine");
		POSTGRE_SQL_CONTAINER.withReuse(true);
		POSTGRE_SQL_CONTAINER.start();
	}

	@DynamicPropertySource
	static void configureProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", POSTGRE_SQL_CONTAINER::getJdbcUrl);
		registry.add("spring.datasource.username", POSTGRE_SQL_CONTAINER::getUsername);
		registry.add("spring.datasource.password", POSTGRE_SQL_CONTAINER::getPassword);
	}

}
