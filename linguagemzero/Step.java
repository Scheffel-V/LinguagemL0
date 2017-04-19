package linguagemzero;

/*
 * Classe que realiza a operação de SmallStep, ou seja, realiza um passo
 * em um termo recebido, e coloca o resultado em t2. Se não for possível
 * realizar um passo no termo, dispara a exceção NoRuleAppliesException.
 * Se o termo for um valor, ou seja, TmZero, TmTrue ou TmFalse, sabemos
 * que esse é um valor final, e isso será dito na mensagem da Exceção.
 * @Scheffel-V
 */
public class Step {
	private Term t2;
	
	public Step(Term t1) throws NoRuleAppliesException {
		switch(t1.getClass().getSimpleName()){
			case "TmIf":
				if(((TmIf)t1).getT1().getClass().getSimpleName().equals("TmTrue")){
					/*
					 * Aplicação da regra E-IfTrue
					 */
					this.t2 = ((TmIf)t1).getT2();
				}else if(((TmIf)t1).getT1().getClass().getSimpleName().equals("TmFalse")){
					/*
					 * Aplicação da regra E-IfFalse
					 */
					this.t2 = ((TmIf)t1).getT3();
				}else{
					try{
						/*
						 * Aplicação da regra E-If
						 */
						this.t2 = new TmIf((new Step(((TmIf)t1).getT1())).getT2(), ((TmIf)t1).getT2(), ((TmIf)t1).getT3());
						}catch(NoRuleAppliesException e){
							if(!e.getMessage().equals("value")){
								/*
								 * Se realizarmos um SmallStep no t1 do If(t1,t2,t3)
								 * e ele nos retornar um NoRuleAppliesException,
								 * e não for um valor final, isso caracteriza um problema,
								 * o termo If inicial já é um valor por não ser possível
								 * realizar um passo.S
								 */
								if(e.getMessage().contentEquals("primeiro erro")){
									throw new NoRuleAppliesException(t1.printTerm());
								}else{
									throw e;
								}
							}else{
								throw e;
							}
						}
					}
				break;
			
			case "TmSucc":
				try{
					/*
					 * Aplicação da regra E-Succ
					 */
					this.t2 = new TmSucc(new Step(((TmSucc)t1).getT1()).getT2());
				}catch(NoRuleAppliesException e){
					if(!e.getMessage().equals("value")){
						if(e.getMessage().contentEquals("primeiro erro")){
							throw new NoRuleAppliesException(t1.printTerm());
						}else{
							throw e;
						}
					}else{
						throw e;
					}
				}
				break;
			
			case "TmPred":
				if(((TmPred)t1).getT1().getClass().getSimpleName().equals("TmZero")){
					/*
					 * Aplicação da regra E-PredZero
					 */
					this.t2 = new TmZero();
				}else if(((TmPred)t1).getT1().getClass().getSimpleName().equals("TmSucc")){
					/*
					 * Aplicação da regra E-PredSucc
					 */
					this.t2 = ((TmSucc)(((TmPred)t1).getT1())).getT1();
				}else{
					try{
						/*
						 * Aplicação da regra E-Pred
						 */
						this.t2 = new TmPred(new Step(((TmPred)t1).getT1()).getT2());
					}catch(NoRuleAppliesException e){
						if(!e.getMessage().equals("value")){
							if(e.getMessage().contentEquals("primeiro erro")){
								throw new NoRuleAppliesException(t1.printTerm());
							}else{
								throw e;
							}
						}else{
							throw e;
						}
					}
				}
				break;
			
			case "TmIsZero":
				if(((TmIsZero)t1).getT1().getClass().getSimpleName().equals("TmZero")){
					/*
					 * Aplicação da regra E-IsZeroZero
					 */
					this.t2 = new TmTrue();
				}else if(((TmIsZero)t1).getT1().getClass().getSimpleName().equals("TmSucc") 
						&& isNumericalValue(((TmSucc)(((TmIsZero)t1).getT1())).getT1()) ){
						/*
						 * Aplicação da regra E-IsZeroSucc
						 */
						this.t2 = new TmFalse();
				}else{
					try{
						/*
						 * Aplicação da regra E-IsZero
						 */
						this.t2 = new TmIsZero(new Step(((TmIsZero)t1).getT1()).getT2());
					}catch(NoRuleAppliesException e){
						if(!e.getMessage().equals("value")){
							if(e.getMessage().contentEquals("primeiro erro")){
								throw new NoRuleAppliesException(t1.printTerm());
							}else{
								throw e;
							}
						}else{
							throw e;
						}
					}
				}
				break;
			
			default:
				/*
				 * Caso não seja TmIf, TmSucc, TmPred, TmIsZero, deverá ser um valor.
				 */
				if(isNumericalValue(t1)){
					/*
					 * Se for valor final, dispara a Exception indicando que
					 * o termo é valor final.
					 */
					throw new NoRuleAppliesException("value");
				}else{
					/* 
					 * Se não, dispara a Exception indicando problema.
					 */
					throw new NoRuleAppliesException("primeiro erro");
				}
		}
	}
	
	public Term getT2(){
		return this.t2;
	}
	
	/*
	 * Função para saber se o termo é um valor numérico.
	 */
	private boolean isNumericalValue(Term t){
		if(t.getClass().getSimpleName().equals("TmZero")){
			return true;
		}else if(t.getClass().getSimpleName().equals("TmSucc")){
			return isNumericalValue(((TmSucc)t).getT1());
		}else{
			return false;
		}
	}
	
	public void printTerm(){
		t2.printTerm();
	}
}
