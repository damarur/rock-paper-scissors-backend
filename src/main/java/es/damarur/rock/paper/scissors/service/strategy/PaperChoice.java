package es.damarur.rock.paper.scissors.service.strategy;

import es.damarur.rock.paper.scissors.model.Choice;
import es.damarur.rock.paper.scissors.model.Result;
import org.springframework.stereotype.Component;

@Component
public class PaperChoice implements ChoiceSelection {

	@Override
	public Choice machineChoice() {
		return Choice.PAPER;
	}

	@Override
	public Result result(Choice userChoice) {
		if (userChoice == Choice.ROCK) {
			return Result.WIN;
		} else if (userChoice == Choice.PAPER) {
			return Result.DRAW;
		} else if (userChoice == Choice.SCISSORS) {
			return Result.LOSE;
		} else {
			// TODO throw a dedicated exception
			return null;
		}
	}

}
