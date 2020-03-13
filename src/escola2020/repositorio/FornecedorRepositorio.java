package escola2020.repositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import escola2020.dominio.Alunos;
import escola2020.dominio.Fornecedor;

public interface FornecedorRepositorio {
	
	public void inserir(Fornecedor forn) throws SQLException;
	
	public ArrayList<Fornecedor> listarTodos() throws SQLException;
	
	public void excluir(Integer id) throws SQLException;
	
	public Fornecedor buscarPeloCodigo(Integer Codigo) throws SQLException;
	
	public void atualizar(Fornecedor forn) throws SQLException;

}
