package es.damarur.rock.paper.scissors.service.strategy;

import es.damarur.rock.paper.scissors.exception.InvalidGameException;
import es.damarur.rock.paper.scissors.model.Choice;
import es.damarur.rock.paper.scissors.model.Result;
import org.springframework.stereotype.Component;

@Component
public class RockChoice implements ChoiceSelection {

	@Override
	public Choice machineChoice() {
		return Choice.ROCK;
	}

	@Override
	public Result result(Choice userChoice) {
		if (userChoice == Choice.ROCK) {
			return Result.DRAW;
		} else if (userChoice == Choice.PAPER) {
			return Result.LOSE;
		} else if (userChoice == Choice.SCISSORS) {
			return Result.WIN;
		} else {
			throw InvalidGameException.invalidGame();
		}
	}

}
