package escola2020.controlador;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.Fornecedor;
import escola2020.servico.ExcecaoPersonalizada;
import escola2020.servico.FornecedorServico;

@SuppressWarnings("serial")
@Named @RequestScoped
public class FornecedorListaManager implements Serializable{
	
	private Fornecedor fornecedor;
	private FornecedorServico servicoFornecedor;
	
	public FornecedorListaManager() {
		fornecedor = new Fornecedor();
		servicoFornecedor = new FornecedorServico();
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
	
	
	public ArrayList<Fornecedor> getFornecedores() {
		try {
			return servicoFornecedor.executeListarFornecedor();
		}catch (ExcecaoPersonalizada e) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO!", e.getMessage());
			context.addMessage(null, msg);
			return null;
		}
	}
	
	public String excluir(Integer codigo) {
		try {
			servicoFornecedor.executeExcluir(codigo);
		}catch(ExcecaoPersonalizada e) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!",e.getMessage());
			contexto.addMessage(null, mensagem);
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
