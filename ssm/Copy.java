package ssm;

public class Copy extends Instructions {
	public Copy() {
		
	}
	
	@Override
	public void executeInstruction(Code code, Stack pilha) throws EmptyStackException {
		pilha.copy();
	}
}
