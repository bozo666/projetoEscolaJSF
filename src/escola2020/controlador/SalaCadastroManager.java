package escola2020.controlador;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.Sala;
import escola2020.servico.ExcecaoPersonalizada;
import escola2020.servico.SalaServico;

@SuppressWarnings("serial")
@Named 
@RequestScoped
public class SalaCadastroManager implements Serializable {

	private Sala sala;
	private SalaServico servico;
	
	public SalaCadastroManager() {
		sala = new Sala();
		servico = new SalaServico();
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public SalaServico getServico() {
		return servico;
	}

	public void setServico(SalaServico servico) {
		this.servico = servico;
	}
	
	public String cadastrar() {
		try {
			servico.executeCadastrar(sala);
		} catch (ExcecaoPersonalizada e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "xabu", e.getMessage());
			fc.addMessage(null, msg);
			return null;
		}
		return "tabelaSalas.xhtml";
	}
	
	public String irPaginaCadastrar() {
		return "registroSalas.xhtml";
	}
	public String irPaginaListar() {
		return "tabelaSalas.xhtml";
	}
	
	
}
