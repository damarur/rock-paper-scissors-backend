package es.damarur.rock.paper.scissors.mapper;

import es.damarur.rock.paper.scissors.generated.dto.ChoiceDTO;
import es.damarur.rock.paper.scissors.generated.dto.GameResultDTO;
import es.damarur.rock.paper.scissors.model.Choice;
import es.damarur.rock.paper.scissors.model.Game;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameMapper {

	GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);

	GameResultDTO toGameResultDTO(Game game);

	Choice toChoice(ChoiceDTO choiceDTO);

}
