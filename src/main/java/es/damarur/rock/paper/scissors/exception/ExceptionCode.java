package es.damarur.rock.paper.scissors.exception;

import java.util.IllegalFormatException;
import org.springframework.http.HttpStatus;

public interface ExceptionCode {

	String getCode();

	HttpStatus getHttpStatus();

	String getMessage();

	default String formattedMessage(Object... args) {
		try {
			return String.format(getMessage(), args);
		} catch (IllegalFormatException e) {
			return getMessage();
		}
	}

}
