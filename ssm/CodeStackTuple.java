package ssm;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import userInterface.InterfaceL0;

/*
 * Definição da tupla (code,stack) que representa a estrutura
 * que une a Pilha de Código e a Pilha de Números Naturais,
 * e as devidas operações de manipulação e execução.
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
			JOptionPane.showMessageDialog(null, "Impossível realizar a operação, visto que a lista está vazia.");
		}
		return 0;
	}
}
