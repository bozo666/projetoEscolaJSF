package escola2020.servico;
import escola2020.repositorio.AlunoRepositorio;
import escola2020.repositorio.AlunoRepositorioImpl;
import escola2020.dominio.Alunos;

import java.sql.SQLException;
import java.util.ArrayList;


public class AlunoServico {
	
	private AlunoRepositorio repositorio;
	
	public AlunoServico(){
		this.repositorio = new AlunoRepositorioImpl();
	}
	
	/**
	 * Valida e salva um usuário no BD
	 * @param usuario Objeto contendo todos os dados para inclusão
	 */
	public void salvar(Alunos al) throws AlunoServicoException{
		try {
			this.repositorio.inserir(al);
		} catch (SQLException exception) {
			throw new AlunoServicoException(exception.getMessage());
		}
	}
	
	/**
	 * Retorna um vetor com todos os dados do BD
	 * @return arraylist de usuario com os elementos encontrados
	 * @throws UsuarioServicoException
	 */
	public ArrayList<Alunos> listar() throws AlunoServicoException{
		try {
			return this.repositorio.getAll();
		} catch (Exception exception) {
			throw new AlunoServicoException(exception.getMessage());
		}
	}
	
	/**
	 * Valida e exclui um usuário no BD
	 * @param ID identificador do registro a ser exluido
	 */
	public void excluir(String matricula) throws AlunoServicoException{
		try {
			this.repositorio.excluir(matricula);
		} catch (SQLException exception) {
			throw new AlunoServicoException(exception.getMessage());
		}
	}
	/**
	 * Valida e salva uma atualização do usuário no BD
	 * @param usuario Objeto contendo todos os dados para inclusao, inclusive o ID
	 */
	public void alterar(Alunos aluno) throws AlunoServicoException{
		try {
			this.repositorio.atualizar(aluno);
		} catch (SQLException exception) {
			throw new AlunoServicoException(exception.getMessage());
		}
	}
}



