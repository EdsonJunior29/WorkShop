package br.com.workshopmongo.services.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.workshopmongo.resources.exception.StandardError;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	/*Essa classe e um manipulador de excecoes na camada de resources.
	 * */
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException error , HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError e = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado" , error.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(e);
	}

}
