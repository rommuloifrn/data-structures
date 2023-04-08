package exceptions;

public class PilhaVaziaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PilhaVaziaException(String err) {
		super(err);
	}

}
