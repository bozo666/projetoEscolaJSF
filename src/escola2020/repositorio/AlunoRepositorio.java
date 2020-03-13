package escola2020.repositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import escola2020.dominio.Alunos;


public interface AlunoRepositorio {
	
	public void inserir(Alunos aluno) throws SQLException;
	
	public void atualizar(Alunos aluno) throws SQLException;
	
	public void excluir(String matricula) throws SQLException;

	public Alunos get(String matricula) throws SQLException;
		/**
	 * Retorna um vetor com todos os registros do BD
	 * @return ArrayList<Usuario> com todos os registros, ou um objeto vazio
	 * @throws SQLException
	 */
	public ArrayList<Alunos> getAll() throws SQLException;
}
