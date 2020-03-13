package escola2020.controlador;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.InsumosCategorias;
import escola2020.servico.ExcecaoPersonalizada;
import escola2020.servico.InsumosCategoriasServico;

@SuppressWarnings("serial")
@Named @SessionScoped
public class InsumosCategoriaAtualizaManager implements Serializable {

	private InsumosCategorias insumosCat;
	private InsumosCategoriasServico servico;
	
	public InsumosCategoriaAtualizaManager() {
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
	
	public String alterar(InsumosCategorias insumoC) {
		insumosCat = insumoC;
		return "atualizaInsumosCategorias.xhtml";
	}
	
	public String cadastrar() {
		try {
			servico.executeAlterar(insumosCat);
		} catch (ExcecaoPersonalizada e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "xabu" + e.getMessage(),"");
			fc.addMessage(null, msg);
			return null;
		}
		return "tabelaInsumosCategorias.xhtml";
	}
	
}
