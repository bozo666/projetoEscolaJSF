package escola2020.repositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import escola2020.dominio.Livros;

public interface LivrosRepositorio {

	public Livros get(String livros) throws SQLException;
	
	public void inserir(Livros livros) throws SQLException;
	
	public void atualizar(Livros livros) throws SQLException;
	
	public void excluir(Integer codigo) throws SQLException;

	/**
	 * Retorna um vetor com todos os registros do BD
	 * 
	 * @return ArrayList<Livros> com todos os registros, ou um objeto vazio
	 * @throws SQLException
	 */

	public ArrayList<Livros> getAll() throws SQLException;

	Livros get(Integer codigo) throws SQLException;

}
