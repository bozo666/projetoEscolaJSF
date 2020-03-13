package escola2020.controlador;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.Cargo;
import escola2020.dominio.Funcionarios;
import escola2020.servico.FuncionarioServico;
import escola2020.servico.FuncionarioServicoException;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class FuncionarioCadastroManager implements Serializable {

	private Funcionarios funcionario;
	private FuncionarioServico servico;

	public FuncionarioCadastroManager() {
		this.setFuncionario(new Funcionarios());
		this.servico = new FuncionarioServico();
	}

	public Funcionarios getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionarios funcionario) {
		this.funcionario = funcionario;
	}

	public String salvar() {
		try {
			servico.salvar(this.funcionario);
		} catch (FuncionarioServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!" + exception.getMessage(), "");
			contexto.addMessage(null, mensagem);
			return null;
		}
		return "tabelaFuncionarios.xhtml";
	}

	public String redirecionaCadastro() {
		return "registroFuncionarios.xhtml";
	}

	public ArrayList<Cargo> getCargos() {
		try {
			return servico.listarCargos();
		} catch (FuncionarioServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO :"+ exception.getMessage(),"");
			contexto.addMessage(null, mensagem);
			return (new ArrayList<Cargo>());
		}
	}
	
	public String cargoSelecionado(Integer codCargo) {
		if(codCargo==funcionario.getCargos_codigo()) {
			return "true";
		}
		return "false";
	}
	
	public String irPaginaCadastrar() {
		return "registroFuncionarios.xhtml";
	}
	public String irPaginaListar() {
		return "tabelaFuncionarios.xhtml";
	}
}
