package es.damarur.rock.paper.scissors.fixtures;

import es.damarur.rock.paper.scissors.model.Choice;
import es.damarur.rock.paper.scissors.model.Game;
import es.damarur.rock.paper.scissors.model.Result;
import java.time.Instant;

public class GameTestObject {

	public static Game createDefault() {
		return createDefault(Choice.ROCK, Choice.PAPER, Result.LOSE);
	}

	public static Game createDefault(Choice userChoice, Choice machineChoice, Result result) {
		return Game.builder()
			.id(1)
			.datetime(Instant.now())
			.nickname("testUser")
			.userChoice(userChoice)
			.machineChoice(machineChoice)
			.result(result)
			.build();
	}

}
