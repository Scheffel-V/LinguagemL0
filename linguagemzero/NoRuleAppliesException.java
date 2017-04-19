package linguagemzero;

/*
 * Excess�o utilizada quando nenhuma regra pode ser aplicada � um termo.
 * @Scheffel-V
 */
@SuppressWarnings("serial")
public class NoRuleAppliesException extends Exception{
	public NoRuleAppliesException(String message) {
		super(message);
	}
}
