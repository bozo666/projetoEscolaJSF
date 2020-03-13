package escola2020.servico;
import escola2020.dominio.*;
import java.sql.SQLException;
import java.util.ArrayList;


import escola2020.repositorio.*;

public class TrabalheConoscoServico {
	public void salvar(TrabalheConosco trabalheConosco) throws TrabalheConoscoServicoException{
		TrabalheConoscoRepositorio repositorio = new TrabalheConoscoRepositorioImpl();
		try {
			repositorio.inserir(trabalheConosco);
		} catch (SQLException exception) {
			throw new TrabalheConoscoServicoException(exception.getMessage());
			
			//System.out.println("Erro"+exception.getMessage());
		}
	}
	public void excluir(int id) throws TrabalheConoscoServicoException{
		TrabalheConoscoRepositorio repositorio = new TrabalheConoscoRepositorioImpl();
		try {
			repositorio.excluir(id);
		} catch (SQLException exception) {
			throw new TrabalheConoscoServicoException(exception.getMessage());
			
			//System.out.println("Erro"+exception.getMessage());
		}
	}
	public void alterar(TrabalheConosco trabalheConosco) throws TrabalheConoscoServicoException{
		TrabalheConoscoRepositorio repositorio = new TrabalheConoscoRepositorioImpl();
		try {
			repositorio.atualizar(trabalheConosco);
		} catch (SQLException exception) {
			throw new TrabalheConoscoServicoException(exception.getMessage());
			
			//System.out.println("Erro"+exception.getMessage());
		}
	}
	/**
	 * Retorna um vetro com todos os dados do DB
	 * @Return Arraylist<Usuario> com todos os elemntos encontrados.
	 * @throws UsuarioServicoException
	 */
	public ArrayList<TrabalheConosco> listar() throws TrabalheConoscoServicoException {
		TrabalheConoscoRepositorio repositorio = new TrabalheConoscoRepositorioImpl();
		try {
			return repositorio.getAll();
		} catch (SQLException exception) {
			throw new TrabalheConoscoServicoException(exception.getMessage());

		}
	}
	
}