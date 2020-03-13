package escola2020.controlador;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.InsumosCategorias;
import escola2020.servico.ExcecaoPersonalizada;
import escola2020.servico.InsumosCategoriasServico;

@Named @SessionScoped
public class InsumosCategoriasListaManager implements Serializable {

	private InsumosCategorias insumosCat;
	private InsumosCategoriasServico servico;
	
	public InsumosCategoriasListaManager() {
		insumosCat = new InsumosCategorias();
		servico = new InsumosCategoriasServico();
	}

	public InsumosCategorias getInsumosCat() {
		return insumosCat;
	}

	public void setInsumosCat(InsumosCategorias insumosCat) {
		this.insumosCat = insumosCat;
	}

	public InsumosCategoriasServico getServico() {
		return servico;
	}

	public void setServico(InsumosCategoriasServico servico) {
		this.servico = servico;
	}
	
	public ArrayList<InsumosCategorias> getInsumosCategorias() {
		try {
			return servico.executeListar();
		}catch (ExcecaoPersonalizada e) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO!", e.getMessage());
			context.addMessage(null, msg);
			return null;
		}
	}
	
	public String excluir(Integer codigo) {
		try {
			servico.executeExcluir(codigo);
		}catch(ExcecaoPersonalizada e) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!",e.getMessage());
			contexto.addMessage(null, mensagem);
		}
		return "tabelaInsumosCategorias.xhtml";
	}
	
}
