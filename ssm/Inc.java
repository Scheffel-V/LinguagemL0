package ssm;

public class Inc extends Instructions{
	public Inc() {
		
	}
	
	@Override
	public void executeInstruction(Code code, Stack pilha) throws EmptyStackException {
		pilha.inc();
	}
}
