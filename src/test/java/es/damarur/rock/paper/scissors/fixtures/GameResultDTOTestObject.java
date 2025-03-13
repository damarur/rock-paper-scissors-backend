package es.damarur.rock.paper.scissors.fixtures;

import es.damarur.rock.paper.scissors.generated.dto.ChoiceDTO;
import es.damarur.rock.paper.scissors.generated.dto.GameResultDTO;
import es.damarur.rock.paper.scissors.generated.dto.ResultDTO;

public class GameResultDTOTestObject {

	public static GameResultDTO createDefault() {
		GameResultDTO gameResultDTO = new GameResultDTO();
		gameResultDTO.setNickname("testUser");
		gameResultDTO.setUserChoice(ChoiceDTO.ROCK);
		gameResultDTO.setMachineChoice(ChoiceDTO.PAPER);
		gameResultDTO.setResult(ResultDTO.LOSE);
		return gameResultDTO;
	}


}
