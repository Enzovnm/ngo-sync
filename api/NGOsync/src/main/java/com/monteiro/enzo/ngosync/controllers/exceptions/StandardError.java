package com.monteiro.enzo.ngosync.controllers.exceptions;

import java.time.Instant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StandardError {

	private Instant timestap;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
}
