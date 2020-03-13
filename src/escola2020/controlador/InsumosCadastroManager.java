package escola2020.controlador;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.Insumo;
import escola2020.servico.ExcecaoPersonalizada;
import escola2020.servico.InsumoServico;

@SuppressWarnings("serial")
@Named @RequestScoped
public class InsumosCadastroManager implements Serializable {
	
	private Insumo insumo;
	private InsumoServico servico;
	
	public InsumosCadastroManager () {
		insumo = new Insumo();
		servico = new InsumoServico();
	}
	
	public Insumo getInsumo() {
		return insumo;
	}
	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	public InsumoServico getServico() {
		return servico;
	}
	public void setServico(InsumoServico servico) {
		this.servico = servico;
	}
	
	public String salvar() {
		try {
			servico.executeCadastrar(this.insumo);
		} catch (ExcecaoPersonalizada exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + exception.getMessage(),"");
			contexto.addMessage(null, mensagem);			
			return null;
		}
		return "tabelaInsumos.xhtml";
	}
	
	
	public String irPaginaCadastrar() {
		return "registroInsumos.xhtml";
	}
	public String irPaginaListar() {
		return "tabelaInsumos.xhtml";
	}
	
}
