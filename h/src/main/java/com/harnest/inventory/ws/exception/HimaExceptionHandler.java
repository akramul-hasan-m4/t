package com.harnest.inventory.ws.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import static com.harnest.inventory.ws.commons.URIConstants.ERROR_MSG;

import java.sql.SQLException;
import java.time.LocalDateTime;
/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

@RestControllerAdvice
public class HimaExceptionHandler extends Exception{

	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ErrorDetails> nullPointerException(NullPointerException e, WebRequest request) {
		String msg = "Error Message =>>>>>>>> " + e.getMessage();
		ErrorDetails ed = setErrorDetails(msg, 500, request.getDescription(false));
		HttpHeaders headers = new HttpHeaders();
		headers.add(ERROR_MSG, msg);
		return new ResponseEntity<>(ed, headers, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InterruptedException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorDetails> interruptedException(InterruptedException e, WebRequest request){
		String msg = "Interrupted Exception Message =>> " + e.getMessage();
		ErrorDetails ed = setErrorDetails(msg, 400, request.getDescription(false));
		HttpHeaders headers = new HttpHeaders();
		headers.add(ERROR_MSG, msg);
		return new ResponseEntity<>(ed, headers, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler({ AccessDeniedException.class })
	@ResponseStatus(value=HttpStatus.FORBIDDEN)
	public ResponseEntity<ErrorDetails> handleAccessDeniedException(Exception ex, WebRequest request) {
		String msg = "You Are Not Allowed for this resource";
		ErrorDetails ed = setErrorDetails(msg, 403, request.getDescription(false));
		HttpHeaders headers = new HttpHeaders();
		headers.add(ERROR_MSG, msg);
		return new ResponseEntity<>(ed, headers, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<ErrorDetails> handleConflict(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "This should be application specific ->> " + ex.getMessage();
		ErrorDetails ed = setErrorDetails(bodyOfResponse, 409, request.getDescription(false));
		HttpHeaders headers = new HttpHeaders();
		headers.add(ERROR_MSG, bodyOfResponse);
		return new ResponseEntity<>(ed, headers, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = {SQLException.class })
	protected ResponseEntity<ErrorDetails> sqlException(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "SQLException Occured: ->> " + ex.getMessage();
		ErrorDetails ed = setErrorDetails(bodyOfResponse, 500, request.getDescription(false));
		HttpHeaders headers = new HttpHeaders();
		headers.add(ERROR_MSG, bodyOfResponse);
		return new ResponseEntity<>(ed, headers, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private ErrorDetails setErrorDetails(String message, Integer errorCode, String path) {
		ErrorDetails ed = new ErrorDetails();
		ed.setTimestamp(LocalDateTime.now());
		ed.setMessage(message);
		ed.setErrorCode(errorCode);
		ed.setPath(path);
		
		return ed;
	}

}
