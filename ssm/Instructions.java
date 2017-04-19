package ssm;

/*
 * Defini��o das instru��es da Pilha de C�digo.
 */
public abstract class Instructions {
	public abstract void executeInstruction(Code code, Stack pilha) throws EmptyStackException;

	public void printInstruction(){
		System.out.print(this.getClass());
	}
}
