package escola2020.controlador;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import escola2020.dominio.TrabalheConosco;
import escola2020.servico.TrabalheConoscoServico;
import escola2020.servico.TrabalheConoscoServicoException;


@SuppressWarnings("serial")
@Named
@SessionScoped
public class TrabalheConoscoAtualizaManager implements Serializable {
	private TrabalheConosco trabalheConosco;
	private TrabalheConoscoServico servico;

	public TrabalheConoscoAtualizaManager() {
		this.trabalheConosco=new TrabalheConosco();
		this.servico=new TrabalheConoscoServico();
	}

	public TrabalheConosco getTrabalheConosco() {
		return trabalheConosco;
	}

	public void setTrabalheConosco(TrabalheConosco trabalheConosco) {
		this.trabalheConosco = trabalheConosco;
	}
	/**
	 * action responsavel por processar os dados para salvar no DB
	 * @return String com o retorno da aplicacao(para onde ir)
	 * 
	 */
	public String alterar(TrabalheConosco trabalheConosco) {
	this.trabalheConosco=trabalheConosco;
	return "atualizaTrabalheConosco.xhtml";
	}
	
	public String salvar() {
	try {		
			servico.alterar(trabalheConosco);
			
	} catch (TrabalheConoscoServicoException exception) {
			FacesContext contexto=FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro",exception.getMessage());
			contexto.addMessage(null, mensagem);
			return null;
		}
		return "tabelaTrabalheConosco.xhtml";
	}

	}

