package escola2020.repositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import escola2020.dominio.TrabalheConosco;


public interface TrabalheConoscoRepositorio {
	public void inserir(TrabalheConosco trabalheConosco)throws SQLException;
	public void atualizar(TrabalheConosco trabalheConosco)throws SQLException;
	public void excluir(int id)throws SQLException;
	//public Turma get(String email) throws SQLException;
	
	/**
	 * Retorna um vetor com todos o registros do DB
	 * @return Arraylist<Usuarios> com todos os registros, ou objeto vazio
	 * @throws SQLException
	 */

	public ArrayList<TrabalheConosco> getAll() throws SQLException;
}
	
