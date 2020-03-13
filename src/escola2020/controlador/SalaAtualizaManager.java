package escola2020.controlador;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.Sala;
import escola2020.servico.ExcecaoPersonalizada;
import escola2020.servico.SalaServico;


@SuppressWarnings("serial")
@Named
@SessionScoped
public class SalaAtualizaManager implements Serializable {

	private Sala sala;
	private SalaServico servico;

	public SalaAtualizaManager() {
		this.sala = new Sala();
		this.servico = new SalaServico();
	}

	public SalaServico getServico() {
		return servico;
	}

	public void setServico(SalaServico servico) {
		this.servico = servico;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	/**
	 * Action responsavel por processar os dados para salvar no BD
	 * 
	 * @return string com o destino da aplicação (para onde ir)
	 */
	public String alterar(Sala sala) {
		this.sala = sala;
		return "atualizaSala.xhtml";
	}

	public String salvar() {
		try {
			servico.alterar(this.sala);
		} catch (ExcecaoPersonalizada exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", exception.getMessage());
			contexto.addMessage(null, mensagem);
			return null;
		}
		return "tabelaSalas.xhtml";
	}

}