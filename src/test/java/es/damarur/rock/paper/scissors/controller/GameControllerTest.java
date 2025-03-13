package es.damarur.rock.paper.scissors.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import es.damarur.rock.paper.scissors.fixtures.GameResultDTOTestObject;
import es.damarur.rock.paper.scissors.fixtures.GameTestObject;
import es.damarur.rock.paper.scissors.generated.dto.ChoiceDTO;
import es.damarur.rock.paper.scissors.generated.dto.GameDTO;
import es.damarur.rock.paper.scissors.generated.dto.GameResultDTO;
import es.damarur.rock.paper.scissors.service.GameService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@WebMvcTest(GameController.class)
class GameControllerTest extends BaseControllerTest {

	@MockitoBean
	private GameService gameService;

	@ParameterizedTest
	@EnumSource(value = ChoiceDTO.class)
	void playGame(ChoiceDTO choiceDTO) throws Exception {
		// Given
		GameDTO gameDTO = new GameDTO().choice(choiceDTO).nickname("testUser");

		// When
		when(gameService.playGame(gameDTO)).thenReturn(GameTestObject.createDefault());

		// Then
		GameResultDTO expectedGameResultDTO = GameResultDTOTestObject.createDefault();
		mockMvc.perform(post("/play")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(gameDTO)))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.nickname").value(expectedGameResultDTO.getNickname()))
			.andExpect(jsonPath("$.user_choice").value(expectedGameResultDTO.getUserChoice().getValue()))
			.andExpect(jsonPath("$.machine_choice").value(expectedGameResultDTO.getMachineChoice().getValue()))
			.andExpect(jsonPath("$.result").value(expectedGameResultDTO.getResult().getValue()));
	}

}
