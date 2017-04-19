package linguagemzero;

/*
 * Classe que realiza a operação de BigStep em um termo recebido.
 * Enquanto for possível realiar um SmallStep, ou seja, não recebe a NoRuleAppliesException,
 * a classe irá continuar realizando SmallStep's. No final, teremos o último termo possível
 * em finalTerm.
 * @Scheffel-V
 */
public class BigStep {
	private Term finalTerm;
	
	public BigStep(Term t1) {
		boolean flag = true;
		finalTerm = t1;
		while(flag){
			try {
				finalTerm = (new Step(finalTerm)).getT2();
			} catch (NoRuleAppliesException e) {
				flag = false;
				if(!e.getMessage().equals("value") && !e.getMessage().equals("primeiro erro")){
					System.err.println("error in " + e.getMessage());
				}
			}
		}
	}
	
	public Term getFinalTerm(){
		return finalTerm;
	}
}
