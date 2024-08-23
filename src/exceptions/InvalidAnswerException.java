package exceptions;

public class InvalidAnswerException extends Exception{
	public InvalidAnswerException() {
		super("resposta invalida");
	}

}
