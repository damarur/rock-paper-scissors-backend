package es.damarur.rock.paper.scissors.repository;

import es.damarur.rock.paper.scissors.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

}
