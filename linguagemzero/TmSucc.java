package linguagemzero;

/*
 * Classe que representa o termo 'succ(t)'.
 * t é um termo.
 * @Scheffel-V
 */
public class TmSucc extends Term {
	private Term t1;
	
	public TmSucc(Term t1) {
		this.t1 = t1;
	}
	
	public Term getT1(){
		return t1;
	}
	
	@Override
	public String printTerm() {
		return "TmSucc(" + t1.printTerm() + ")";
	}
}
