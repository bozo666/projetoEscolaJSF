package escola2020.servico;
@SuppressWarnings("serial")
public class AlunoServicoException extends Exception{

	public AlunoServicoException(Throwable exception) {
		super(exception);
	}
	public AlunoServicoException(String mensagem) {
		super(mensagem);
	}
	public AlunoServicoException() {
		super();
	}
}
