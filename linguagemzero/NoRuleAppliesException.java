package linguagemzero;

/*
 * Excessão utilizada quando nenhuma regra pode ser aplicada à um termo.
 * @Scheffel-V
 */
@SuppressWarnings("serial")
public class NoRuleAppliesException extends Exception{
	public NoRuleAppliesException(String message) {
		super(message);
	}
}
