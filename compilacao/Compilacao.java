package compilacao;

import linguagemzero.Term;
import linguagemzero.TmIf;
import linguagemzero.TmSucc;
import linguagemzero.TmIsZero;
import linguagemzero.TmPred;
import ssm.Code;
import ssm.Copy;
import ssm.Dec;
import ssm.Inc;
import ssm.Jump;
import ssm.JumpIfZero;
import ssm.Push;

public class Compilacao {
	
	public Compilacao(Term term, Code code) {
		switch(term.getClass().getSimpleName()){
			case "TmTrue":
				code.addInstruction(new Push(1));
				break;
			
			case "TmFalse":
				code.addInstruction(new Push(0));
				break;
			
			case "TmZero":
				code.addInstruction(new Push(0));
				break;
				
			case "TmSucc":
				code.addInstruction(new Inc());
				new Compilacao((((TmSucc)term).getT1()), code);
				break;
				
			case "TmIf":
				int n2 = length(((TmIf)term).getT2());
				int n3 = length(((TmIf)term).getT3());
				
			    new Compilacao((((TmIf)term).getT3()), code);
				code.addInstruction(new Jump(n3));
				new Compilacao((((TmIf)term).getT2()), code);
				code.addInstruction(new JumpIfZero(n2 + 1));
				new Compilacao((((TmIf)term).getT1()), code);
				break;
			
			case "TmIsZero":
				code.addInstruction(new Push(1));
				code.addInstruction(new Jump(1));
				code.addInstruction(new Push(0));
				code.addInstruction(new JumpIfZero(2));
				new Compilacao((((TmIsZero)term).getT1()), code);
				break;
				
			case "TmPred":
				code.addInstruction(new Dec());
				code.addInstruction(new JumpIfZero(1));
				code.addInstruction(new Copy());
				new Compilacao((((TmPred)term).getT1()), code);
				break;
		}	
	}
	
	private int length(Term term){
		switch(term.getClass().getSimpleName()){
			case "TmTrue":
				return 1;
			
			case "TmFalse":
				return 1;
			
			case "TmZero":
				return 1;
			
			case "TmSucc":
				return 1 + length(((TmSucc)term).getT1());
				
			case "TmIf":
				return 2 + length(((TmIf)term).getT1()) + length(((TmIf)term).getT2()) + length(((TmIf)term).getT3());
				
			case "TmIsZero":
				return 4 + length(((TmIsZero)term).getT1());
			
			case "TmPred":
				return 3 + length(((TmPred)term).getT1());
			
			default:
				return -1;
		}
	}
}
