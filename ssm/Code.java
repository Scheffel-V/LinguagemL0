package ssm;

import java.util.ArrayList;

/*
 * Defini��o do c�digo da Pilha de C�digo, que possui
 * uma lista de instru��es e os devidos comandos para
 * manipular essa lista, de forma que ela passa a ser
 * uma pilha, e exeutar as instru��es.
 * @Scheffel-V
 */
public class Code {
	private ArrayList<Instructions> lista;
	
	public Code() {
		lista = new ArrayList<Instructions>();
	}
	
	public ArrayList<Instructions> getCodeList(){
		return lista;
	}
	
	public boolean isEmpty(){
		return lista.isEmpty();
	}
	
	public void addInstruction(Instructions instruction){
		ArrayList<Instructions> listaAux = new ArrayList<Instructions>();
		for(Instructions inst : lista){
			listaAux .add(inst);
		}
		lista.clear();
		lista.add(instruction);
		for(Instructions inst : listaAux){
			lista.add(inst);
		}
	} 
	
	public void executeInstruction(Stack pilha) throws EmptyStackException {
		lista.get(0).executeInstruction(this, pilha);
		removeInstruction();
	}
	
	public void removeInstruction() throws EmptyStackException{
		if(lista.isEmpty()){
			throw new EmptyStackException("removeInstruction");
		}else{
			lista.remove(0);
		}
	}
	
	public void printCode(){
		int i = 0;
		for(Instructions inst : lista){
			System.out.print("[" + i + "]");
			inst.printInstruction();
			System.out.println();
			i++;
		}
	}
}
