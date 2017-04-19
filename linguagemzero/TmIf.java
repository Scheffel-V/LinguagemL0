package linguagemzero;

/*
 * Classe que representa o termo 'if(t1,t2,t3)'.
 * t1,t2,t2 são termos.
 * @Scheffel-V
 */
public class TmIf extends Term{
	private Term t1;
	private Term t2;
	private Term t3;
	
	public TmIf(Term t1, Term t2, Term t3) {
		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
	}
	
	public Term getT1(){
		return t1;
	}
	
	public Term getT2(){
		return t2;
	}
	
	public Term getT3(){
		return t3;
	}
	
	@Override
	public String printTerm() {
		return "TmIf("+ t1.printTerm() + "," + t2.printTerm() 
				+ "," + t3.printTerm() + ")";
	}
}
