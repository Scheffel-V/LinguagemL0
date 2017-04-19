package ssm;

public class Pop extends Instructions {
	public Pop() {
		
	}
	
	@Override
	public void executeInstruction(Code code, Stack pilha) throws EmptyStackException {
		pilha.pop();
	}
}
