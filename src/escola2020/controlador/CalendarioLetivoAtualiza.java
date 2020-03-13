package escola2020.controlador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.PartialResponseWriter;
import javax.inject.Named;
import javax.servlet.http.Part;

import escola2020.dominio.CalendarioLetivo;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class CalendarioLetivoAtualiza implements Serializable {

	private CalendarioLetivo calendario;
	
	public CalendarioLetivoAtualiza() {
		this.calendario= new CalendarioLetivo();
	}

	public void saveFile() {

		try (InputStream input = calendario.getUploadedFile().getInputStream()) {
			String fileName = calendario.getUploadedFile().getSubmittedFileName();
			Files.copy(input, new File(calendario.getFolder(), fileName).toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
