package escola2020.controlador;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.Funcionarios;
import escola2020.servico.FuncionarioServico;
import escola2020.servico.FuncionarioServicoException;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class FuncionarioAtualizaManager implements Serializable{
	
	private Funcionarios funcionario;
	private FuncionarioServico servico;
	
	public FuncionarioAtualizaManager() {
		this.funcionario = new Funcionarios();
		this.servico = new FuncionarioServico();
	}

	public FuncionarioServico getServico() {
		return servico;
	}

	public void setServico(FuncionarioServico servico) {
		this.servico = servico;
	}

	public Funcionarios getFuncionario() {
		return funcionario ;
	}

	public void setFuncionario(Funcionarios funcionario) {
		this.funcionario = funcionario;
	}
	
	/**
	 * Action responsavel por processar os dados para salvar no BD
	 * @return string com o destino da aplicação (para onde ir)
	 */
	public String alterar(Funcionarios obj){
			this.funcionario=obj;
			return "atualizaFuncionario.xhtml";
	}
	
	public String atualizar(){
				try {
			servico.alterar(funcionario);
		} catch (FuncionarioServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",exception.getMessage());
			contexto.addMessage(null, mensagem);			
			return null;
		}
		return "tabelaFuncionarios.xhtml";
	}
}