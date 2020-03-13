package escola2020.controlador;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.servico.TrabalheConoscoServico;
import escola2020.servico.TrabalheConoscoServicoException;
import escola2020.servico.TurmaServicoException;
import escola2020.dominio.*;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class TrabalheConoscoListaManager implements Serializable {
	private TrabalheConosco trabalheConosco;
	private TrabalheConoscoServico servico;

	public TrabalheConoscoListaManager() {
		this.trabalheConosco = new TrabalheConosco();
		this.servico = new TrabalheConoscoServico();

	}

	public TrabalheConosco getTrabalheConosco() {
		return trabalheConosco;
	}

	public void setTrabalheConosco(TrabalheConosco trabalheConosco) {
		this.trabalheConosco = trabalheConosco;
	}
	public String excluir(int id) {
		try {
			servico.excluir(id);

		} catch (TrabalheConoscoServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", exception.getMessage());
			contexto.addMessage(null, mensagem);
			
			}
		return null;
		}
	/**
	 * action responsavel por processar os dados para salvar no DB
	 * 
	 * @return String com o retorno da aplicacao(para onde ir)
	 */
	public ArrayList<TrabalheConosco> getTrabalhemConosco() {
		try {
			return servico.listar();

		} catch (TrabalheConoscoServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", exception.getMessage());
			contexto.addMessage(null, mensagem);
			return null;
		}

	}
}