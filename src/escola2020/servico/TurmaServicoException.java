package escola2020.servico;
@SuppressWarnings("serial")
public class TurmaServicoException extends Exception{
	public TurmaServicoException(Throwable exception) {
		super(exception);
	}
	public TurmaServicoException(String mensagem) {
		super(mensagem);
	}
	public TurmaServicoException() {
		super();
	}
}

