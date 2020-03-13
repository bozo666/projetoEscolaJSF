package escola2020.repositorio;

import java.sql.SQLException;
import java.util.ArrayList;


import escola2020.dominio.Turma;


public interface TurmaRepositorio {
	public void inserir(Turma turma)throws SQLException;
	public void atualizar(Turma turma)throws SQLException;
	public void excluir(String codigo)throws SQLException;
	//public Turma get(String email) throws SQLException;
	
	/**
	 * Retorna um vetor com todos o registros do DB
	 * @return Arraylist<TrabalheConosco> com todos os registros, ou objeto vazio
	 * @throws SQLException
	 */

	public ArrayList<Turma> getAll() throws SQLException;
	
}
	
