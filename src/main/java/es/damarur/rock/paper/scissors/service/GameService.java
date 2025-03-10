package es.damarur.rock.paper.scissors.service;

import es.damarur.rock.paper.scissors.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {

	private final GameRepository gameRepository;

}
