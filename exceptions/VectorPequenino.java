package exceptions;

public class VectorPequenino extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public VectorPequenino(String err) {
		super(err);
	}
}
