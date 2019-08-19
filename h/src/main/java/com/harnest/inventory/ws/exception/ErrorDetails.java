package com.harnest.inventory.ws.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetails {

	private LocalDateTime timestamp;
	private String message;
	private Integer errorCode;
	private String path;
}
