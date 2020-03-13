package escola2020.servico;
@SuppressWarnings("serial")
public class CargoServicoException extends Exception{

	public CargoServicoException(Throwable exception) {
		super(exception);
	}
	public CargoServicoException(String mensagem) {
		super(mensagem);
	}
	public CargoServicoException() {
		super();
	}
}
