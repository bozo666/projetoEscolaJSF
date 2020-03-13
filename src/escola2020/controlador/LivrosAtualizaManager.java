package escola2020.controlador;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.Livros;
import escola2020.servico.LivroServicoException;
import escola2020.servico.LivrosServico;

@Named
@SessionScoped
@SuppressWarnings("serial")

public class LivrosAtualizaManager implements Serializable {
	
	private Livros livros;
	private LivrosServico servico;
	
	public LivrosAtualizaManager() {
		this.livros = new Livros();
		this.servico = new LivrosServico();
	}

	public LivrosServico getServico() {
		return servico;
	}

	public void setServico(LivrosServico servico) {
		this.servico = servico;
	}

	public Livros getLivros() {	
		return livros;
	}

	public void setLivros(Livros livros) {
		this.livros = livros;
	}
	
	/**
	 * Action responsavel por processar os dados para salvar no BD
	 * @return string com o destino da aplicação (para onde ir)
	 */
	public String alterar(Livros livros){
			this.livros=livros;
			return "atualizaLivros.xhtml";
	}
	
	public String salvar (){
				try {	
			servico.alterar(livros);
		} catch (LivroServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",exception.getMessage());
			contexto.addMessage(null, mensagem);			
			return null;
		}
		return "tabelaLivros.xhtml";
	}

}
