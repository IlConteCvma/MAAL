package execption;

public class QuestionException extends NoSuchMethodException{
	private static final long serialVersionUID = 123457869000L;
	
	public QuestionException() {
		
	}
	
	public QuestionException(String message) {
		super("Problem in question operation:" + message);
	}
	public QuestionException(Throwable message) {
		super("Problem in question operation: ");
		this.initCause(message);
		this.printStackTrace();
	}
	

}
