package execption;

public class QuestionException extends Exception{
	private static final long serialVersionUID = 123457869000L;
	
	public QuestionException(String message) {
		super("Problem in question operation:" + message);
	}
	

}
