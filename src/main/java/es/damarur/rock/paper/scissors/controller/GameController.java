package es.damarur.rock.paper.scissors.controller;

import es.damarur.rock.paper.scissors.generated.api.GameApi;
import es.damarur.rock.paper.scissors.generated.dto.GameDTO;
import es.damarur.rock.paper.scissors.generated.dto.GameResultDTO;
import es.damarur.rock.paper.scissors.generated.dto.UserStatsDTO;
import es.damarur.rock.paper.scissors.mapper.GameMapper;
import es.damarur.rock.paper.scissors.model.Game;
import es.damarur.rock.paper.scissors.model.Result;
import es.damarur.rock.paper.scissors.service.GameService;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GameController implements GameApi {

	private final GameService gameService;

	@Override
	public ResponseEntity<UserStatsDTO> getGames(@Valid @RequestParam(value = "nickname") String nickname) {
		Map<Result, Long> stats = gameService.getGames(nickname);
		UserStatsDTO userStatsDTO = new UserStatsDTO();
		userStatsDTO.setNickname(nickname);
		userStatsDTO.setWins(BigDecimal.valueOf(stats.getOrDefault(Result.WIN, 0L)));
		userStatsDTO.setLosses(BigDecimal.valueOf(stats.getOrDefault(Result.LOSE, 0L)));
		userStatsDTO.setDraws(BigDecimal.valueOf(stats.getOrDefault(Result.DRAW, 0L)));
		return ResponseEntity.ok(userStatsDTO);
	}

	@Override
	public ResponseEntity<GameResultDTO> playGame(@Valid @RequestBody GameDTO gameDTO) {
		Game game = gameService.playGame(gameDTO);
		return ResponseEntity.ok(GameMapper.INSTANCE.toGameResultDTO(game));
	}

}
