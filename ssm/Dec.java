package ssm;

public class Dec extends Instructions{
	public Dec() {
		
	}
	
	@Override
	public void executeInstruction(Code code, Stack pilha) throws EmptyStackException {
		pilha.dec();
	}
}
