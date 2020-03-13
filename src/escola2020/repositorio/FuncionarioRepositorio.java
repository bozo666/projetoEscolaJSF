package escola2020.repositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import escola2020.dominio.Cargo;
import escola2020.dominio.Funcionarios;


public interface FuncionarioRepositorio {
	
	public void inserir(Funcionarios funcionario) throws SQLException;
	
	public void atualizar(Funcionarios funcionario) throws SQLException;
	
	public void excluir(String matricula) throws SQLException;

	public Funcionarios get(String matricula) throws SQLException;
		/**
	 * Retorna um vetor com todos os registros do BD
	 * @return ArrayList<FuncionariosFuncionarios funcionario> com todos os registros, ou um objeto vazio
	 * @throws SQLException
	 */
	public ArrayList<Funcionarios> getAll() throws SQLException;
	
	public ArrayList<Cargo>getCargos()throws SQLException;
	
}
