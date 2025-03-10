package es.damarur.rock.paper.scissors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {RockPaperScissorsBackendApplication.class})
public class RockPaperScissorsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RockPaperScissorsBackendApplication.class, args);
	}

}
