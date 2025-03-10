package es.damarur.rock.paper.scissors.service;

import es.damarur.rock.paper.scissors.model.Choice;
import es.damarur.rock.paper.scissors.model.Game;
import es.damarur.rock.paper.scissors.model.Result;
import es.damarur.rock.paper.scissors.repository.GameRepository;
import es.damarur.rock.paper.scissors.service.strategy.ChoiceSelection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {

	private final GameRepository gameRepository;
	private final List<ChoiceSelection> choiceSelectionList;

	public Game playGame(Choice userChoice) {
		Choice machineChoice = getRandomChoice();
		Result result = choiceSelectionList.stream()
			.filter(choiceSelection -> choiceSelection.machineChoice().equals(machineChoice))
			.map(choiceSelection -> choiceSelection.result(userChoice))
			.findFirst()
			.orElseThrow(() -> new IllegalStateException("No strategy found for user choice: " + userChoice));
		return saveGame(userChoice, machineChoice, result);
	}

	private Game saveGame(Choice userChoice, Choice machineChoice, Result result) {
		Game game = Game.builder()
			.userChoice(userChoice)
			.machineChoice(machineChoice)
			.result(result)
			.build();
		return gameRepository.save(game);
	}

	private Choice getRandomChoice() {
		Choice[] choices = Choice.values();
		int randomIndex = ThreadLocalRandom.current().nextInt(choices.length); // NOSONAR
		return choices[randomIndex];
	}

}
