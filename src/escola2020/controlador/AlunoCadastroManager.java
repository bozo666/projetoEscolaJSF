package escola2020.controlador;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.servico.AlunoServico;
import escola2020.dominio.Alunos;
import escola2020.servico.AlunoServicoException;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class AlunoCadastroManager implements Serializable{
	
		private Alunos aluno;
		private AlunoServico servico;
		
		public AlunoCadastroManager() {
			this.aluno = new Alunos();
			this.servico = new AlunoServico();
		}

		public Alunos getAluno() {
			return aluno;
		}

		public void setAluno(Alunos aluno) {
			this.aluno = aluno;
		}
		
		/**
		 * Action responsavel por processar os dados para salvar no BD
		 * @return string com o destino da aplicação (para onde ir)
		 */
		public String salvar() {
			try {
				servico.salvar(this.aluno);
			} catch (AlunoServicoException exception) {
				FacesContext contexto = FacesContext.getCurrentInstance();
				FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",exception.getMessage());
				contexto.addMessage(null, mensagem);			
				return null;
			}
			return "tabelaAlunos.xhtml";
		}
		
		public String irPaginaCadastrar() {
			return "registroAlunos.xhtml";
		}
		public String irPaginaListar() {
			return "tabelaAlunos.xhtml";
		}

	}
