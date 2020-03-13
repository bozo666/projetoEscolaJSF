package escola2020.servico;
@SuppressWarnings("serial")
public class EquipamentoServicoException extends Exception{
	public EquipamentoServicoException(Throwable exception) {
		super(exception);
	}
	public EquipamentoServicoException(String mensagem) {
		super(mensagem);
	}
	public EquipamentoServicoException() {
		super();
	}
}