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
		return switch (userChoice) {
			case Choice.ROCK -> Result.LOSE;
			case Choice.PAPER -> Result.DRAW;
			case Choice.SCISSORS -> Result.WIN;
		};
	}

}
