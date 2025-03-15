package es.damarur.rock.paper.scissors.repository;

import es.damarur.rock.paper.scissors.model.Game;
import es.damarur.rock.paper.scissors.projection.ResultCountProjection;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

	@Query("SELECT new es.damarur.rock.paper.scissors.projection.ResultCountProjection(g.result, COUNT(g)) " +
		"FROM Game g " +
		"WHERE g.nickname = :nickname " +
		"GROUP BY g.result")
	Set<ResultCountProjection> countGroupByResultForNickname(String nickname);

}
