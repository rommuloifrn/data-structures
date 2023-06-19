package exceptions;

public class NaoAcheiEsteTreco extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NaoAcheiEsteTreco(String err) {
		super(err);
	}

}
