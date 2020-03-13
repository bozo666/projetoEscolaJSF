package escola2020.servico;

@SuppressWarnings("serial")
public class ExcecaoPersonalizada extends Exception{
	
	public ExcecaoPersonalizada (Throwable e) {
		super(e);
	}
	
	public ExcecaoPersonalizada (String str) {
		super(str);
	}
	
	public ExcecaoPersonalizada() {
		
	}

}
