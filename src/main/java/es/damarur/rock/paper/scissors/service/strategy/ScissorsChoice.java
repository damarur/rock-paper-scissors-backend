package es.damarur.rock.paper.scissors.service.strategy;

import es.damarur.rock.paper.scissors.model.Choice;
import es.damarur.rock.paper.scissors.model.Result;
import org.springframework.stereotype.Component;

@Component
public class ScissorsChoice implements ChoiceSelection {

	@Override
	public Choice machineChoice() {
		return Choice.SCISSORS;
	}

	@Override
	public Result result(Choice userChoice) {
		return switch (userChoice) {
			case Choice.ROCK -> Result.WIN;
			case Choice.PAPER -> Result.LOSE;
			case Choice.SCISSORS -> Result.DRAW;
		};
	}

}
