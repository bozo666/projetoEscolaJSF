package escola2020.servico;

import escola2020.repositorio.CalendarioRepositorio;
import escola2020.repositorio.CalendarioRepositorioImpl;

import escola2020.dominio.CalendarioLetivo;

import java.sql.SQLException;

public class CalendarioServico {
	
	private CalendarioRepositorio repositorio;
	
	public CalendarioServico(){
		this.repositorio = new CalendarioRepositorioImpl();
	}
	
	/**
	 * Valida e salva um usuário no BD
	 * @param usuario Objeto contendo todos os dados para inclusão
	 */
	public void salvar(CalendarioLetivo cal) throws AlunoServicoException{
		try {
			this.repositorio.inserir(cal);
		} catch (SQLException exception) {
			throw new AlunoServicoException(exception.getMessage());
		}
	}
	
		
	/**
	 * Valida e exclui um usuário no BD
	 * @param ID identificador do registro a ser exluido
	 */
	public void excluir(int id) throws AlunoServicoException{
		try {
			this.repositorio.excluir(id);
		} catch (SQLException exception) {
			throw new AlunoServicoException(exception.getMessage());
		}
	}
	/**
	 * Valida e salva uma atualização do usuário no BD
	 * @param usuario Objeto contendo todos os dados para inclusao, inclusive o ID
	 */
	public void alterar(CalendarioLetivo cal) throws AlunoServicoException{
		try {
			this.repositorio.atualizar(cal);
		} catch (SQLException exception) {
			throw new AlunoServicoException(exception.getMessage());
		}
	}
}



