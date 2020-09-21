package br.com.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	/*Criar uma excecao personalizada para disparar quando tentar 
	 * buscar um usuario por Id, fornencendo um id inexistente*/
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
}
