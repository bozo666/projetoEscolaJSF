package escola2020.controlador;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.Funcionarios;

import escola2020.servico.FuncionarioServico;
import escola2020.servico.FuncionarioServicoException;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class FuncionarioListarManager implements Serializable {

	private Funcionarios funcionario;
	private FuncionarioServico servico;

	public FuncionarioListarManager() {
		this.setFuncionario(new Funcionarios());
		this.servico = new FuncionarioServico();
	}

	public Funcionarios getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionarios funcionario) {
		this.funcionario = funcionario;
	}

	public ArrayList<Funcionarios> getFuncionarios() {
		try {
			return servico.listar();
		} catch (FuncionarioServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO :", exception.getMessage());
			contexto.addMessage(null, mensagem);
			return (new ArrayList<Funcionarios>());
		}

	}

	public String excluir(Funcionarios funcionario) {
		try {
			servico.excluir(funcionario.getCpf());
		} catch (FuncionarioServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", exception.getMessage());
			contexto.addMessage(null, mensagem);
		}
		return "tabelaFuncionarios.xhtml";
	}
	
	
	
	
	
	public String redirecionaCadastro() {
		return "registroFuncionarios.xhtml";
	}
	
	
	
	
	
	

}
