package ssm;

/*
 * Definição das instruções da Pilha de Código.
 */
public abstract class Instructions {
	public abstract void executeInstruction(Code code, Stack pilha) throws EmptyStackException;

	public void printInstruction(){
		System.out.print(this.getClass());
	}
}
