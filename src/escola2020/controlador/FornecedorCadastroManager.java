package escola2020.controlador;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.Fornecedor;
import escola2020.servico.ExcecaoPersonalizada;
import escola2020.servico.FornecedorServico;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class FornecedorCadastroManager implements Serializable {

	private Fornecedor fornecedor;
	private FornecedorServico servicoFornecedor;
	
	public FornecedorCadastroManager() {
		servicoFornecedor = new FornecedorServico();
		fornecedor = new Fornecedor();
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public FornecedorServico getServicoFornecedor() {
		return servicoFornecedor;
	}

	public void setServicoFornecedor(FornecedorServico servicoFornecedor) {
		this.servicoFornecedor = servicoFornecedor;
	}

	public String cadastrar() {
		try {
			servicoFornecedor.executeCadastrar(this.fornecedor);
		} catch (ExcecaoPersonalizada e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "xabu" + e.getMessage(),"");
			fc.addMessage(null, msg);
			return null;
		}
		return "tabelaFornecedores.xhtml";
	}
	
	public String irPaginaCadastrar() {
		return "registroFornecedores.xhtml";
	}
	public String irPaginaListar() {
		return "tabelaFornecedores.xhtml";
	}

}
