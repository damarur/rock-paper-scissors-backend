package es.damarur.rock.paper.scissors.controller;

import es.damarur.rock.paper.scissors.generated.api.GameApi;
import es.damarur.rock.paper.scissors.generated.dto.ChoiceSelectionDTO;
import es.damarur.rock.paper.scissors.generated.dto.GameResultDTO;
import es.damarur.rock.paper.scissors.mapper.GameMapper;
import es.damarur.rock.paper.scissors.model.Choice;
import es.damarur.rock.paper.scissors.model.Game;
import es.damarur.rock.paper.scissors.service.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GameController implements GameApi {

	private final GameService gameService;

	@Override
	public ResponseEntity<GameResultDTO> playGame(@Valid @RequestBody ChoiceSelectionDTO choiceSelectionDTO) {
		Choice userChoice = GameMapper.INSTANCE.toChoice(choiceSelectionDTO.getChoice());
		Game game = gameService.playGame(userChoice);
		return ResponseEntity.ok(GameMapper.INSTANCE.toGameResultDTO(game));
	}

}
