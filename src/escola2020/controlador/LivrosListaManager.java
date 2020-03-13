package escola2020.controlador;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.xml.ws.Action;

import escola2020.dominio.Livros;
import escola2020.servico.LivroServicoException;
import escola2020.servico.LivrosServico;

@Named
@RequestScoped
@SuppressWarnings("serial")
public class LivrosListaManager implements Serializable {

	private Livros livro;

	private LivrosServico servico;

	public LivrosListaManager() {
		livro = new Livros();
		servico = new LivrosServico();


	}

	public Livros getLivro() {
		return livro;
	}

	public void setLivro(Livros livro) {
		this.livro = livro;
	}

	public LivrosServico getServico() {
		return servico;
	}

	public void setServico(LivrosServico servico) {
		this.servico = servico;
	}

	/**
	 * Metodo que retorna todos os elementos cadastrados no BD
	 * @return ArrayList<Usuario> com todos os elementos
	 */
	public ArrayList<Livros> getLivros(){
		try {
			return servico.listar();
		}catch(LivroServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!",exception.getMessage());
			contexto.addMessage(null, mensagem);
			return (new ArrayList<Livros>());
			
	}
}
	@Action
	public String excluir(Integer codigo) {
		try {
			servico.excluir(codigo);
		} catch (LivroServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",exception.getMessage());
			contexto.addMessage(null, mensagem);			
		}
		return "tabelaLivros.xhtml";
	}
	
}