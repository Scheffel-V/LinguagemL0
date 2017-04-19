package linguagemzero;

/*
 * Definição da classe que representa o "Term".
 * Todos os termos serão reconhecidos pelo sistema seguindo a seguinte condição:
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
