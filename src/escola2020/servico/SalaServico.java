package escola2020.servico;

import java.sql.SQLException;
import java.util.ArrayList;

import escola2020.dominio.Alunos;
import escola2020.dominio.Sala;
import escola2020.repositorio.AlunoRepositorio;
import escola2020.repositorio.AlunoRepositorioImpl;
import escola2020.repositorio.SalaRepositorio;
import escola2020.repositorio.SalaRepositorioImpl;

public class SalaServico {
	
private SalaRepositorio repositorio;
	
	public SalaServico(){
		this.repositorio = new SalaRepositorioImpl();
	}
	
	public ArrayList<Sala> executeListarSalas() throws ExcecaoPersonalizada{
		SalaRepositorio dao = new SalaRepositorioImpl();
		try {
			return dao.listarTodas();
		}
		catch(SQLException e) {
			throw new ExcecaoPersonalizada(e.getMessage());
		}
	}
	
	public void executeCadastrar(Sala sala) throws ExcecaoPersonalizada {
		SalaRepositorio dao = new SalaRepositorioImpl();
		try {
			dao.inserir(sala);
		}catch(SQLException e) {
			throw new ExcecaoPersonalizada(e.getMessage());
		}
	}
	/**
	 * Valida e exclui um usuário no BD
	 * @param ID identificador do registro a ser exluido
	 */
	public void excluir(Integer codigo) throws ExcecaoPersonalizada{
		try {
			this.repositorio.excluir(codigo);
		} catch (SQLException exception) {
			throw new ExcecaoPersonalizada(exception.getMessage());
		}
	}
	/**
	 * Valida e salva uma atualização do usuário no BD
	 * @param usuario Objeto contendo todos os dados para inclusao, inclusive o ID
	 */
	public void alterar(Sala sala) throws ExcecaoPersonalizada{
		try {
			this.repositorio.atualizar(sala);
		} catch (SQLException exception) {
			throw new ExcecaoPersonalizada(exception.getMessage());
		}
	}
}
