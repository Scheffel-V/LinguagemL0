package linguagemzero;

/*
 * Defini��o da classe que representa o "Term".
 * Todos os termos ser�o reconhecidos pelo sistema seguindo a seguinte condi��o:
 * _________________________________________
 * | ENTRADA (string)   NO SISTEMA (classe) |
 * | 0				    TmZero				|
 * | true				TmTrue				|
 * | false			    TmFalse				|
 * | succ(t)			TmSucc				|
 * | pred(t)			TmPred				|
 * | iszero(t)		    TmIsZero			|
 * | if(t1,t2,t3)		TmIf				|
 * |________________________________________|
 * @Scheffel-V
 */
public abstract class Term {
	public abstract String printTerm();
}
