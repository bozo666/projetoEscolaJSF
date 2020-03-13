package escola2020.servico;

import java.sql.SQLException;
import java.util.ArrayList;

import escola2020.dominio.Fornecedor;
import escola2020.dominio.InsumosCategorias;
import escola2020.repositorio.FornecedorRepositorio;
import escola2020.repositorio.FornecedorRepositorioImpl;
import escola2020.repositorio.InsumoCategoriaRepositorio;
import escola2020.repositorio.InsumoCategoriaRepositorioImpl;

public class InsumosCategoriasServico {
	
	public void executeCadastrar(InsumosCategorias insumosCat) throws ExcecaoPersonalizada {
		InsumoCategoriaRepositorio dao = new InsumoCategoriaRepositorioImpl();
		try {
			dao.inserir(insumosCat);
		}catch(SQLException e) {
			throw new ExcecaoPersonalizada(e.getMessage());
		}
	}
	
	public ArrayList<InsumosCategorias> executeListar() throws ExcecaoPersonalizada {
		InsumoCategoriaRepositorio dao = new InsumoCategoriaRepositorioImpl();
		try {
			return dao.listarTodos();
		}
		catch(SQLException e) {
			throw new ExcecaoPersonalizada(e.getMessage());
		}
	}
	
	public void executeExcluir(Integer byCodigo)throws ExcecaoPersonalizada {
		InsumoCategoriaRepositorio dao = new InsumoCategoriaRepositorioImpl();
		try {
			dao.excluir(byCodigo);
		}catch(SQLException exception) {
			throw new ExcecaoPersonalizada(exception.getMessage());
		}
	}
	
	public void executeAlterar(InsumosCategorias byCodigo) throws ExcecaoPersonalizada{
		InsumoCategoriaRepositorio dao = new InsumoCategoriaRepositorioImpl();
		try {
			dao.atualizar(byCodigo);
		} catch (SQLException exception) {
			throw new ExcecaoPersonalizada(exception.getMessage());
		}
	}

}
