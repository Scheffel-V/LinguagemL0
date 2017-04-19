package ssm;

public class Push extends Instructions {
	private int z;
	
	public Push(int z) {
		this.z = z;
	}
	
	public int getZ(){
		return z;
	}
	@Override
	public void executeInstruction(Code code, Stack pilha) {
		pilha.push(z);
	}
}
