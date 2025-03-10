package es.damarur.rock.paper.scissors.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public class InvalidGameException extends AbstractException {

	private InvalidGameException(ExceptionCode exceptionCode) {
		super(exceptionCode);
	}

	public static InvalidGameException invalidGame() {
		return new InvalidGameException(InvalidGameExceptionCode.INVALID_GAME);
	}

	@AllArgsConstructor
	@Getter
	public enum InvalidGameExceptionCode implements ExceptionCode {
		INVALID_GAME("INVALID_GAME", HttpStatus.NOT_ACCEPTABLE, "Game can't be computed");

		private final String code;
		private final HttpStatus httpStatus;
		private final String message;
	}

}
