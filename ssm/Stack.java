package ssm;

import java.util.ArrayList;

/*
 * Definição da pilha de inteiros que representa a Stack,
 * que possui uma lista de inteiros e os devidos comandos
 * para manipular a lista, de forma que ela passa a ser
 * uma pilha, e o conteúdo dela é numeros inteiros.
 * @Scheffel-V
 */
public class Stack {
	private ArrayList<Integer> lista;
	
	public Stack() {
		lista = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> getStackList(){
		return lista;
	}
	
	public int getTop() throws EmptyStackException{
		if(lista.isEmpty()){
			throw new EmptyStackException("getTop");
		}else{
			return this.lista.get(0);
		}
	}
	
	public void push(int z){
		ArrayList<Integer> listaAux = new ArrayList<Integer>();
		for(Integer valor : lista){
			listaAux.add(valor);
		}
		lista.clear();
		lista.add(z);
		for(Integer valor : listaAux){
			lista.add(valor);
		}
	}
	
	public void pop() throws EmptyStackException{
		if(lista.isEmpty()){
			throw new EmptyStackException("pop");
		}else{
			lista.remove(0);
		}
	}
	
	public void copy() throws EmptyStackException{
		if(lista.isEmpty()){
			throw new EmptyStackException("isTopZero");
		}else{
			ArrayList<Integer> listaAux = new ArrayList<Integer>();;
			for(Integer valor : lista){
				listaAux.add(valor);
			}
			lista.clear();
			lista.add(listaAux.get(0));
			for(Integer valor : listaAux){
				lista.add(valor);
			}
		}
	}
	
	public void inc() throws EmptyStackException{
		if(lista.isEmpty()){
			throw new EmptyStackException("inc");
		}else{
			lista.set(0, lista.get(0)+1);
		}
	}
	
	public void dec() throws EmptyStackException{
		if(lista.isEmpty()){
			throw new EmptyStackException("dec");
		}else{
			lista.set(0, lista.get(0)-1);
		}
	}
	
	public boolean isTopZero() throws EmptyStackException{
		if(lista.isEmpty()){
			throw new EmptyStackException("isTopZero");
		}else{
			if(lista.get(0) == 0){
				lista.remove(0);
				return true;
			}else{
				lista.remove(0);
				return false;
			}
		}
	}
	
	public void printStack(){
		int i=0;
		for(Integer value : lista){
			System.out.println("[" + i + "]" + value);
			i++;
		}
	}
}
