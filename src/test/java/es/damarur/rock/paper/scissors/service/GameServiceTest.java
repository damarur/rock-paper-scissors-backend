package es.damarur.rock.paper.scissors.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import es.damarur.rock.paper.scissors.fixtures.GameTestObject;
import es.damarur.rock.paper.scissors.model.Choice;
import es.damarur.rock.paper.scissors.model.Game;
import es.damarur.rock.paper.scissors.model.Result;
import es.damarur.rock.paper.scissors.repository.GameRepository;
import es.damarur.rock.paper.scissors.service.strategy.PaperChoice;
import es.damarur.rock.paper.scissors.service.strategy.RockChoice;
import es.damarur.rock.paper.scissors.service.strategy.ScissorsChoice;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class GameServiceTest {

	@Mock
	private GameRepository gameRepository;

	private GameService gameService;

	@BeforeAll
	static void setUp() {
		mockStatic(ThreadLocalRandom.class);
		ThreadLocalRandom randomMock = mock(ThreadLocalRandom.class);
		when(randomMock.nextInt(Choice.values().length)).thenReturn(1); // index 1 is PAPER
		when(ThreadLocalRandom.current()).thenReturn(randomMock);
	}

	@Nested
	class StrategyFound {

		@Mock
		private RockChoice rockChoice;

		@Mock
		private PaperChoice paperChoice;

		@Mock
		private ScissorsChoice scissorsChoice;

		@BeforeEach
		void setUp() {
			gameService = new GameService(gameRepository, List.of(rockChoice, paperChoice, scissorsChoice));
		}

		@ParameterizedTest
		@MethodSource("getExpectedResults")
		void playGame(Choice userChoice, Result expectedResult) {
			// Given
			Choice machineChoice = Choice.PAPER;

			// When
			when(gameRepository.save(any(Game.class))).thenReturn(GameTestObject.createDefault(userChoice, machineChoice, expectedResult));
			when(rockChoice.machineChoice()).thenReturn(Choice.ROCK);
			when(paperChoice.machineChoice()).thenReturn(Choice.PAPER);
			when(scissorsChoice.machineChoice()).thenReturn(Choice.SCISSORS);
			when(paperChoice.result(userChoice)).thenReturn(expectedResult);

			// Then
			Game resultGame = gameService.playGame(userChoice);
			assertThat(resultGame.getUserChoice()).isEqualTo(userChoice);
			assertThat(resultGame.getMachineChoice()).isEqualTo(Choice.PAPER);
			assertThat(resultGame.getResult()).isEqualTo(expectedResult);
		}

		private static Stream<Arguments> getExpectedResults() {
			return Stream.of(
				Arguments.of(Choice.ROCK, Result.WIN),
				Arguments.of(Choice.PAPER, Result.DRAW),
				Arguments.of(Choice.SCISSORS, Result.LOSE)
			);
		}

	}

	@Nested
	class NoStrategyFound {

		@BeforeEach
		void setUp() {
			gameService = new GameService(gameRepository, List.of());
		}

		@Test
		void playGame() {
			// Arrange
			Choice userChoice = Choice.ROCK;

			// Act & Assert
			IllegalStateException exception = assertThrows(IllegalStateException.class, () -> gameService.playGame(userChoice));
			assertEquals("No strategy found for user choice: ROCK", exception.getMessage());
		}

	}

}