package escola2020.controlador;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.Alunos;
import escola2020.dominio.Fornecedor;
import escola2020.servico.ExcecaoPersonalizada;
import escola2020.servico.FornecedorServico;

@SuppressWarnings("serial")
@Named @SessionScoped
public class FornecedorAtualizaManager implements Serializable{

	private Fornecedor fornecedor;
	private FornecedorServico servico;
	
	public FornecedorAtualizaManager() {
		fornecedor = new Fornecedor();
		servico = new FornecedorServico();
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public FornecedorServico getServico() {
		return servico;
	}

	public void setServico(FornecedorServico servico) {
		this.servico = servico;
	}
	
	public String alterar(Fornecedor forn) {
		fornecedor = forn;
		return "atualizaFornecedor.xhtml";
	}
	
	public String cadastrar() {
		try {
			servico.alterar(fornecedor);
		} catch (ExcecaoPersonalizada e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "xabu"+ e.getMessage(),"");
			fc.addMessage(null, msg);
			return null;
		}
		return "tabelaFornecedores.xhtml";
	}
	
}
