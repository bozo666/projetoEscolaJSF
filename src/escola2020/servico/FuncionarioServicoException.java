package escola2020.servico;
@SuppressWarnings("serial")
public class FuncionarioServicoException extends Exception{

	public FuncionarioServicoException(Throwable exception) {
		super(exception);
	}
	public FuncionarioServicoException(String mensagem) {
		super(mensagem);
	}
	public FuncionarioServicoException() {
		super();
	}
}
