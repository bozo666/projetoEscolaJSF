package escola2020.servico;
@SuppressWarnings("serial")
public class TrabalheConoscoServicoException extends Exception{
	public TrabalheConoscoServicoException(Throwable exception) {
		super(exception);
	}
	public TrabalheConoscoServicoException(String mensagem) {
		super(mensagem);
	}
	public TrabalheConoscoServicoException() {
		super();
	}
}
