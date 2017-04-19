package ssm;

@SuppressWarnings("serial")
public class EmptyStackException extends Exception{
	public EmptyStackException(String message) {
		super("EmptyStackException in:"+message);
	}
	
}
