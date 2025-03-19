package es.damarur.rock.paper.scissors;

import es.damarur.rock.paper.scissors.config.CustomProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackageClasses = {RockPaperScissorsApplication.class})
@EnableConfigurationProperties(CustomProperties.class)
public class RockPaperScissorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RockPaperScissorsApplication.class, args);
	}

}
