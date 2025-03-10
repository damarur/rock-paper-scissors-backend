package es.damarur.rock.paper.scissors.repository;

import static org.assertj.core.api.Assertions.assertThat;

import es.damarur.rock.paper.scissors.fixtures.GameTestObject;
import es.damarur.rock.paper.scissors.model.Game;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class GameRepositoryTest extends AbstractJpaIntegrationTestBase {

	@Autowired
	private GameRepository gameRepository;

	@Test
	void testAll() {
		Game game = GameTestObject.createDefault().toBuilder().id(null).build();
		Game savedGame = gameRepository.save(game);

		assertThat(gameRepository.findAll()).contains(savedGame);
		assertThat(gameRepository.findById(savedGame.getId())).isPresent();
		assertThat(gameRepository.findById(savedGame.getId() + 1)).isNotPresent();

		gameRepository.delete(savedGame);
		assertThat(gameRepository.findAll()).doesNotContain(savedGame);
		assertThat(gameRepository.findById(savedGame.getId())).isNotPresent();
	}

}
