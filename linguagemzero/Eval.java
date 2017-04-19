package linguagemzero;

/*
 * Classe que realiza a opera��o Eval, que recebe um termo e coloca o SmalLStep 
 * em t. Se n�o for poss�vel realizar o SmallStep, coloca null em t.]
 * @Scheffel-V
 */
public class Eval {
	private Term t=null;
	
	public Eval(Term t) {
		try {
			t = (new Step(t)).getT2();
		} catch (NoRuleAppliesException e) {
			this.t = t;
		}
	}
	
	public Term getT(){
		return t;
	}
}
