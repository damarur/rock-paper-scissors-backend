package es.damarur.rock.paper.scissors.service.strategy;

import es.damarur.rock.paper.scissors.model.Choice;
import es.damarur.rock.paper.scissors.model.Result;

public interface ChoiceSelection {

	Choice machineChoice();

	Result result(Choice userChoice);

}
