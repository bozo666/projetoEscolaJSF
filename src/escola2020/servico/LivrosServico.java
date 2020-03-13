package escola2020.servico;

import java.util.ArrayList;

import escola2020.dominio.Livros;
import escola2020.repositorio.LivrosRepositorio;
import escola2020.repositorio.LivrosRepositorioImpl;

import java.sql.SQLException;

public class LivrosServico {

	private LivrosRepositorio repositorio;

	public LivrosServico() {
		this.repositorio = new LivrosRepositorioImpl();

	}

	/**
	 * Valida e salva um usuário no BD
	 * 
	 * @param usuario Objeto contendo todos os dados para inclusão
	 */
	public void salvar(Livros livros) throws LivroServicoException {
		try {
			this.repositorio.inserir(livros);
		} catch (SQLException exception) {
			throw new LivroServicoException(exception.getMessage());
		}
	}

	public ArrayList<Livros> listar() throws LivroServicoException {
		try {
			return this.repositorio.getAll();
		} catch (Exception exception) {
			throw new LivroServicoException(exception.getMessage());
		}

	}

	/**
	 * Valida e exclui um usuário no BD
	 * 
	 * @param ID identificador do registro a ser exluido
	 */
	public void excluir(Integer codigo) throws LivroServicoException {
		try {
			this.repositorio.excluir(codigo);
		} catch (SQLException exception) {
			throw new LivroServicoException(exception.getMessage());
		}
	}

	/**
	 * Valida e salva uma atualização do usuário no BD
	 * 
	 * @param usuario Objeto contendo todos os dados para inclusao, inclusive o ID
	 */
	public void alterar(Livros livros) throws LivroServicoException {
		try {
			this.repositorio.atualizar(livros);
		} catch (SQLException exception) {
			throw new LivroServicoException(exception.getMessage());
		}
	}

}
