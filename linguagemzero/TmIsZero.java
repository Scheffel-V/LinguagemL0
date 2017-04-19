package linguagemzero;

/*
 * Classe que repreenta o termo 'iszero(t)'.
 * t é um termo.
 * @Scheffel-V
 */
public class TmIsZero extends Term {
	private Term t1;
	
	public TmIsZero(Term t1) {
		this.t1 = t1;
	}
	
	public Term getT1(){
		return t1;
	}
	
	@Override
	public String printTerm() {
		return "TmIsZero(" + t1.printTerm() + ")";
		
	}
}
