package escola2020.servico;

import java.sql.SQLException;
import java.util.ArrayList;

import escola2020.dominio.Alunos;
import escola2020.dominio.Fornecedor;
import escola2020.repositorio.FornecedorRepositorio;
import escola2020.repositorio.FornecedorRepositorioImpl;

public class FornecedorServico {
	
	//Instancia a implementação da interface DAO, e está pronto para ser chamado pelo Bean
	public void executeCadastrar(Fornecedor fornecedor) throws ExcecaoPersonalizada {
		FornecedorRepositorio dao = new FornecedorRepositorioImpl();
		try {
			dao.inserir(fornecedor);
		}catch(SQLException e) {
			throw new ExcecaoPersonalizada(e.getMessage());
		}
	}
	
	public ArrayList<Fornecedor> executeListarFornecedor() throws ExcecaoPersonalizada {
		FornecedorRepositorio dao = new FornecedorRepositorioImpl();
		try {
			return dao.listarTodos();
		}
		catch(SQLException e) {
			throw new ExcecaoPersonalizada(e.getMessage());
		}
	}
	
	public void executeExcluir(Integer forn)throws ExcecaoPersonalizada {
		FornecedorRepositorio dao = new FornecedorRepositorioImpl();
		try {
			dao.excluir(forn);
		}catch(SQLException exception) {
			throw new ExcecaoPersonalizada(exception.getMessage());
		}
	}
	
	public void alterar(Fornecedor forn) throws ExcecaoPersonalizada{
		FornecedorRepositorio dao = new FornecedorRepositorioImpl();
		try {
			dao.atualizar(forn);
		} catch (SQLException exception) {
			throw new ExcecaoPersonalizada(exception.getMessage());
		}
	}
	
}
