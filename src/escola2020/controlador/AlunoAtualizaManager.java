package escola2020.controlador;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.Alunos;
import escola2020.servico.AlunoServico;
import escola2020.servico.AlunoServicoException;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class AlunoAtualizaManager implements Serializable {

	private Alunos aluno;
	private AlunoServico servico;

	public AlunoAtualizaManager() {
		this.aluno = new Alunos();
		this.servico = new AlunoServico();
	}

	public AlunoServico getServico() {
		return servico;
	}

	public void setServico(AlunoServico servico) {
		this.servico = servico;
	}

	public Alunos getAluno() {
		return aluno;
	}

	public void setAluno(Alunos aluno) {
		this.aluno = aluno;
	}

	/**
	 * Action responsavel por processar os dados para salvar no BD
	 * 
	 * @return string com o destino da aplicação (para onde ir)
	 */
	public String alterar(Alunos aluno) {
		this.aluno = aluno;
		return "atualizaAluno.xhtml";
	}

	public String salvar() {
		try {
			servico.alterar(this.aluno);
		} catch (AlunoServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", exception.getMessage());
			contexto.addMessage(null, mensagem);
			return null;
		}
		return "tabelaAlunos.xhtml";
	}

}