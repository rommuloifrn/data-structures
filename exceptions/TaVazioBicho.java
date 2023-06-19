package exceptions;

public class TaVazioBicho extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TaVazioBicho(String err) {
		super(err);
	}

}
