package exceptions;

public class NemTemNadaAiRapaz extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NemTemNadaAiRapaz(String err) {
		super(err);
	}
}
