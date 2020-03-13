package escola2020.dominio;


import java.io.InputStream;

import javax.servlet.http.Part;

public class CalendarioLetivo {

	private int id;
	private Part arquivo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Part getArquivo() {
		return arquivo;
	}
	public void setArquivo(Part arquivo) {
		this.arquivo = arquivo;
	}

	
	
}