package escola2020.repositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import escola2020.dominio.Cargo;
import escola2020.dominio.Funcionarios;



public interface CargoRepositorio {
	
	    public void inserir(Cargo cargo) throws SQLException;
		public Cargo get(String matricula) throws SQLException;
		/**
	 * Retorna um vetor com todos os registros do BD
	 * @return ArrayList<CargosCargos funcionario> com todos os registros, ou um objeto vazio
	 * @throws SQLException
	 */
	public ArrayList<Cargo> getAll() throws SQLException;
	

	public void excluir(Integer id) throws SQLException;
	
	public void atualizar (Cargo cargo) throws SQLException;
}
