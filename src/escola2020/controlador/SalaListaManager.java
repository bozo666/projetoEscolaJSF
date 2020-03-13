package escola2020.controlador;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.xml.ws.Action;

import escola2020.dominio.Sala;
import escola2020.servico.AlunoServicoException;
import escola2020.servico.ExcecaoPersonalizada;
import escola2020.servico.SalaServico;

@SuppressWarnings("serial")
@Named 
@RequestScoped
public class SalaListaManager implements Serializable {
	
	private Sala sala;
	private SalaServico serviceSala;
	
	public SalaListaManager() {
		serviceSala = new SalaServico();
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public SalaServico getServiceSala() {
		return serviceSala;
	}

	public void setServiceSala(SalaServico serviceSala) {
		this.serviceSala = serviceSala;
	}
	
	public ArrayList<Sala> getSalas(){
		try {
			return serviceSala.executeListarSalas();
		}
		catch(ExcecaoPersonalizada e) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO!", e.getMessage());
			context.addMessage(null, msg);
			return null;
		}
	}
	
	@Action
	public String excluir(int codigo) {
		try {
			serviceSala.excluir(codigo);
		} catch (ExcecaoPersonalizada exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",exception.getMessage());
			contexto.addMessage(null, mensagem);			
		}
		return "tabelaSalas.xhtml";
	}
	
	

}
