package ssm;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import userInterface.InterfaceL0;

/*
 * Defini��o da tupla (code,stack) que representa a estrutura
 * que une a Pilha de C�digo e a Pilha de N�meros Naturais,
 * e as devidas opera��es de manipula��o e execu��o.
 * @Scheffel-V
 */
public class CodeStackTuple {
	private Stack stack;
	private Code code;
	
	public CodeStackTuple(InterfaceL0 interfaceSSM) {
		this.stack = new Stack();
		this.code = new Code();
	}
	
	public Stack getStack(){
		return this.stack;
	}
	
	public Code getCode(){
		return this.code;
	}
	
	public void printCode(){
		this.code.printCode();
	}
	
	public void printStack(){
		this.stack.printStack();
	}
	
	public void execute(){
		try {
			this.code.executeInstruction(stack);
		} catch (EmptyStackException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public int executeAll(InterfaceL0 interfaceSSM){
		try {
			while(!this.code.isEmpty()){
				interfaceSSM.updateUI(code.getCodeList(), stack.getStackList());
				this.code.executeInstruction(stack);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			interfaceSSM.updateUI(code.getCodeList(), stack.getStackList());
		} catch (EmptyStackException e) {
			System.err.println(e.getMessage());
		}
		try {
			return this.stack.getTop();
		} catch (EmptyStackException e) {
			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Imposs�vel realizar a opera��o, visto que a lista est� vazia.");
		}
		return 0;
	}
}
