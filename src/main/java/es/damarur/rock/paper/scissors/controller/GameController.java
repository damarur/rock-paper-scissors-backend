package es.damarur.rock.paper.scissors.controller;

import es.damarur.rock.paper.scissors.generated.api.GameApi;
import es.damarur.rock.paper.scissors.generated.dto.GameResultDTO;
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
	public ResponseEntity<GameResultDTO> playGame(@Valid @RequestBody String body) {
		// TODO implement
		return ResponseEntity.ok(new GameResultDTO());
	}

}
