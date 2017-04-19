package ssm;

public class JumpIfZero extends Instructions{
	private int n;
	
	public JumpIfZero(int n) {
		this.n = n;
	}
	
	public int getN(){
		return n;
	}
	
	@Override
	public void executeInstruction(Code code, Stack pilha) throws EmptyStackException {
		if(pilha.isTopZero()){
			Jump jump = new Jump(this.n);
			jump.executeInstruction(code, pilha);
		}
	}
}
