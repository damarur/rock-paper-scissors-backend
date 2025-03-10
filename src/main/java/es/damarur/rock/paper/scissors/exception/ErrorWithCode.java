package es.damarur.rock.paper.scissors.exception;

import org.springframework.http.HttpStatus;

public interface ErrorWithCode {

	default HttpStatus getHttpStatus() {
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}

}
