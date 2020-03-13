package escola2020.controlador;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.TrabalheConosco;

import escola2020.servico.TrabalheConoscoServico;
import escola2020.servico.TrabalheConoscoServicoException;


@SuppressWarnings("serial")
@Named
@RequestScoped
public class TrabalheConoscoCadastroManager implements Serializable {
	private TrabalheConosco trabalheConosco;
	private TrabalheConoscoServico servico;

	public TrabalheConoscoCadastroManager() {
		this.trabalheConosco = new TrabalheConosco();
		this.servico = new TrabalheConoscoServico();
	}

	public TrabalheConosco getTrabalheConosco() {
		return trabalheConosco;
	}

	public void setTrabalheConosco(TrabalheConosco trabalheConosco) {
		this.trabalheConosco = trabalheConosco;
	}

	/**
	 * action responsavel por processar os dados para salvar no DB
	 * 
	 * @return String com o retorno da aplicacao(para onde ir)
	 */
	public String salvar() {
		try {
			servico.salvar(this.trabalheConosco);

		} catch (TrabalheConoscoServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", exception.getMessage());
			contexto.addMessage(null, mensagem);
			return null;
		}
		return "tabelaTrabalheConosco.xhtml";
	}
	public String irPaginaCadastrar() {
		return "registroTrabalheConosco.xhtml";
	}
	public String irPaginaListar() {
		return "tabelaTrabalheConosco.xhtml";
	}
}
