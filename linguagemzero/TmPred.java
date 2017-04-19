package linguagemzero;

/*
 * Classe que representa o termo 'pred(t)'.
 * t é um termo.
 * @Scheffel-V
 */
public class TmPred extends Term{
	private Term t1;
	
	public TmPred(Term t1) {
		this.t1 = t1;
	}
	
	public Term getT1(){
		return t1;
	}
	
	@Override
	public String printTerm() {
		return "TmPred(" + t1.printTerm() + ")";
		
	}
}	
