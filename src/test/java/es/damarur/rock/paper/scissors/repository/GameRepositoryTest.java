package es.damarur.rock.paper.scissors.repository;

import static org.assertj.core.api.Assertions.assertThat;

import es.damarur.rock.paper.scissors.fixtures.GameTestObject;
import es.damarur.rock.paper.scissors.model.Game;
import es.damarur.rock.paper.scissors.model.Result;
import es.damarur.rock.paper.scissors.projection.ResultCountProjection;
import java.util.Set;
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

	@Test
	void testCountGroupByResultForNickname() {
		Game game = GameTestObject.createDefault().toBuilder().id(null).build();
		Game savedGame = gameRepository.save(game);

		Set<ResultCountProjection> resultCountProjections = gameRepository.countGroupByResultForNickname(savedGame.getNickname());
		assertThat(resultCountProjections).hasSize(1).contains(new ResultCountProjection(Result.LOSE, 1L));

		gameRepository.delete(savedGame);
	}

}
