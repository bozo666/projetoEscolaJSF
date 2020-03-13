package escola2020.controlador;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.xml.ws.Action;

import escola2020.dominio.Alunos;
import escola2020.servico.AlunoServico;
import escola2020.servico.AlunoServicoException;
@SuppressWarnings("serial")
@Named
@RequestScoped
public class AlunoListaManager implements Serializable {

	private Alunos aluno;
	private AlunoServico servico;

	public AlunoListaManager() {
			this.aluno = new Alunos();
			this.servico = new AlunoServico();
		}

	public Alunos getAluno() {
		return aluno;
	}

	public AlunoServico getServico() {
		return servico;
	}

	public void setServico(AlunoServico servico) {
		this.servico = servico;
	}

	public void setAluno(Alunos aluno) {
		this.aluno = aluno;
	}

	/**
	 * Método que retorna todos os elementos cadastrados no BD 
	 * @return ArrayList de usuarios com todos os elementos
	 */
	public ArrayList<Alunos> getAlunos() {
		try {
			return servico.listar();
		} catch (AlunoServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",exception.getMessage());
			contexto.addMessage(null, mensagem);			
			return null;
		}
	}
	/**
	 * Action, remove um registro do banco de dados a partir de um ID
	 * return String Destino da View
	*/
	@Action
	public String excluir(Alunos aluno) {
		try {
			servico.excluir(aluno.getMatricula());
		} catch (AlunoServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",exception.getMessage());
			contexto.addMessage(null, mensagem);			
		}
		return "tabelaAlunos.xhtml";
	}
	 
	@Action
	public String excluir(String matricula) {
		try {
			servico.excluir(matricula);
		} catch (AlunoServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",exception.getMessage());
			contexto.addMessage(null, mensagem);			
		}
		return "tabelaAlunos.xhtml";
	}
}


