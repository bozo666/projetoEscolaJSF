package escola2020.servico;
import escola2020.dominio.*;
import java.sql.SQLException;
import java.util.ArrayList;

import escola2020.repositorio.*;





public class TurmaServico {
	public void salvar(Turma turma) throws TurmaServicoException{
		TurmaRepositorio repositorio = new TurmaRepositorioImpl();
		try {
			repositorio.inserir(turma);
		} catch (SQLException exception) {
			throw new TurmaServicoException(exception.getMessage());
			
			//System.out.println("Erro"+exception.getMessage());
		}
	}
	public void excluir(String codigo) throws TurmaServicoException{
		TurmaRepositorio repositorio = new TurmaRepositorioImpl();
		try {
			repositorio.excluir(codigo);
		} catch (SQLException exception) {
			throw new TurmaServicoException(exception.getMessage());
			
			//System.out.println("Erro"+exception.getMessage());
		}
	}
	public void alterar(Turma turma) throws TurmaServicoException{
		TurmaRepositorio repositorio = new TurmaRepositorioImpl();
		try {
			repositorio.atualizar(turma);
		} catch (SQLException exception) {
			throw new TurmaServicoException(exception.getMessage());
			
			//System.out.println("Erro"+exception.getMessage());
		}
	}
	/**
	 * Retorna um vetro com todos os dados do DB
	 * @Return Arraylist<Usuario> com todos os elemntos encontrados.
	 * @throws UsuarioServicoException
	 */
	public ArrayList<Turma> listar() throws TurmaServicoException {
		TurmaRepositorio repositorio = new TurmaRepositorioImpl();
		try {
			return repositorio.getAll();
		} catch (SQLException exception) {
			throw new TurmaServicoException(exception.getMessage());

		}
	}	
}