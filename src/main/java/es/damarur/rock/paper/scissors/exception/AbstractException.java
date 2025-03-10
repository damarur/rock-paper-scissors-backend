package es.damarur.rock.paper.scissors.exception;

import java.util.LinkedHashMap;
import java.util.Map;

public class AbstractException extends RuntimeException implements ErrorWithCode {

	private final transient ExceptionCode exceptionCode;
	private final transient Map<String, Object> additionalDetails = new LinkedHashMap<>();

	protected AbstractException(ExceptionCode exceptionCode) {
		super(exceptionCode.getMessage());
		this.exceptionCode = exceptionCode;
	}

	protected AbstractException(ExceptionCode exceptionCode, Map<String, Object> args) {
		super(exceptionCode.formattedMessage(args.values()));
		this.exceptionCode = exceptionCode;
		this.additionalDetails.putAll(args);
	}

}
