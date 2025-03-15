package es.damarur.rock.paper.scissors.service;

import es.damarur.rock.paper.scissors.exception.InvalidGameException;
import es.damarur.rock.paper.scissors.generated.dto.GameDTO;
import es.damarur.rock.paper.scissors.mapper.GameMapper;
import es.damarur.rock.paper.scissors.model.Choice;
import es.damarur.rock.paper.scissors.model.Game;
import es.damarur.rock.paper.scissors.model.Result;
import es.damarur.rock.paper.scissors.repository.GameRepository;
import es.damarur.rock.paper.scissors.service.strategy.ChoiceSelection;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {

	private final GameRepository gameRepository;
	private final List<ChoiceSelection> choiceSelectionList;

	public Map<Result, Long> getGames(String nickname) {
		return gameRepository.countGroupByResultForNickname(nickname).stream()
			.collect(Collectors.toMap(k -> k.result(), v -> v.count()));
	}

	public Game playGame(GameDTO game) {
		Choice userChoice = GameMapper.INSTANCE.toChoice(game.getChoice());
		if (userChoice == null) {
			throw InvalidGameException.invalidGame();
		}
		Choice machineChoice = getRandomChoice();
		Result result = choiceSelectionList.stream()
			.filter(choiceSelection -> choiceSelection.machineChoice().equals(machineChoice))
			.map(choiceSelection -> choiceSelection.result(userChoice))
			.findFirst()
			.orElseThrow(() -> new IllegalStateException("No strategy found for user choice: " + userChoice));
		return saveGame(game.getNickname(), userChoice, machineChoice, result);
	}

	private Game saveGame(String nickname, Choice userChoice, Choice machineChoice, Result result) {
		Game game = Game.builder()
			.nickname(nickname)
			.userChoice(userChoice)
			.machineChoice(machineChoice)
			.result(result)
			.datetime(Instant.now())
			.build();
		return gameRepository.save(game);
	}

	private Choice getRandomChoice() {
		Choice[] choices = Choice.values();
		int randomIndex = ThreadLocalRandom.current().nextInt(choices.length); // NOSONAR
		return choices[randomIndex];
	}

}
