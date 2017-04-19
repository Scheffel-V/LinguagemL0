package ssm;

public class Jump extends Instructions{
	private int n;
	
	public Jump(int n) {
		this.n = n;
	}
	
	public int getN(){
		return n;
	}
	
	@Override
	public void executeInstruction(Code code, Stack pilha) throws EmptyStackException {
		for(int i = 0; i < this.n ; i++){
			code.removeInstruction();
		}
	}
}
