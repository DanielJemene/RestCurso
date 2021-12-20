package br.com.erudio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OperaçãoNãoSuportada extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public OperaçãoNãoSuportada(String exception) {
		super(exception);
	}

}
