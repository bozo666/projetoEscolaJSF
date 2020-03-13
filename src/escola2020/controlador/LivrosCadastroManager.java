package escola2020.controlador;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.Livros;
import escola2020.servico.LivroServicoException;
import escola2020.servico.LivrosServico;


@SuppressWarnings("serial")
@Named
@RequestScoped
public class LivrosCadastroManager implements  Serializable {
	private Livros livros;
	private LivrosServico servico;
	
	public LivrosCadastroManager() {
		this.livros = new Livros();
		this.servico = new LivrosServico();
	}

	public Livros getLivro() {
		return livros;
	}

	public void setLivros(Livros livros) {
		this.livros = livros;
	}
	
	/**
	 * Action responsavel por processar os dados para salvar no BD
	 * @return string com o destino da aplicação (para onde ir)
	 */
	public String salvar() {
		try {
			servico.salvar(this.livros);
		} catch (LivroServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",exception.getMessage());
			contexto.addMessage(null, mensagem);			
			return null;
		}
		return "tabelaLivros.xhtml";
	}
	
	public String irPaginaCadastrar() {
		return "registroLivros.xhtml";
	}
	public String irPaginaListar() {
		return "tabelaLivros.xhtml";
	}

}

	


