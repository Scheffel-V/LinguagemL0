package sistemadetipos;

import javax.swing.JOptionPane;

import linguagemzero.Term;
import linguagemzero.TmIf;
import linguagemzero.TmIsZero;
import linguagemzero.TmPred;
import linguagemzero.TmSucc;

/*
 * Implementação de um Sistema de Tipos, que recebe um termo
 * e verifica se ele cumpre todas as regras do Sistema de Tipos
 * estabelecidas, retornando true. Caso contrário, retorna false.
 */
public class SistemaDeTipos {

	public static boolean verificarTermo(Term term){
		try{
			verificar(term);
			return true;
		}catch(SistemaDeTiposException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}
	
	private static Type verificar(Term term) throws SistemaDeTiposException{
		switch(term.getClass().getSimpleName()){
			case "TmTrue":
				return new Bool();
			
			case "TmFalse":
				return new Bool();
			
			case "TmZero":
				return new Nat();
			
			case "TmIf":
				if(verificar(((TmIf)term).getT1()).getClass().getSimpleName().equals("Bool")){
					if(verificar(((TmIf)term).getT2()).getClass().getSimpleName().equals("Bool") &&
							verificar(((TmIf)term).getT3()).getClass().getSimpleName().equals("Bool")){
							return new Bool();
					}else{
						if(verificar(((TmIf)term).getT2()).getClass().getSimpleName().equals("Nat") &&
								verificar(((TmIf)term).getT3()).getClass().getSimpleName().equals("Nat")){
							return new Nat();
						}else{
							throw new SistemaDeTiposException("TmIf(t1,t2,t3), t2:T2 t3:T3 -> T2 != T3");
						}
					}
				}else{
					throw new SistemaDeTiposException("TmIf(t1,t2,t3), t1:T1 -> T1 != Bool");
				}
			
			case "TmSucc":
				if(verificar(((TmSucc)term).getT1()).getClass().getSimpleName().equals("Nat")){
					return new Nat();
				}else{
					throw new SistemaDeTiposException("TmSucc(t), t:T -> T != Nat");
				}
				
			case "TmPred":
				if(verificar(((TmPred)term).getT1()).getClass().getSimpleName().equals("Nat")){
					return new Nat();
				}else{
					throw new SistemaDeTiposException("TmPred(t), t:T -> T != Nat");
				}
				
			case "TmIsZero":
				if(verificar(((TmIsZero)term).getT1()).getClass().getSimpleName().equals("Nat")){
					return new Bool();
				}else{
					throw new SistemaDeTiposException("TmIsZero(t), t:T -> T != Bool");
				}
			
			default:
				throw new SistemaDeTiposException("Problema na verificação de tipo.");
		}
	}
}
