package escola2020.repositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import escola2020.dominio.Fornecedor;
import escola2020.dominio.Insumo;
import escola2020.dominio.InsumosCategorias;

public interface InsumoCategoriaRepositorio {

public void inserir(InsumosCategorias insumoC) throws SQLException;
	
	public ArrayList<InsumosCategorias> listarTodos() throws SQLException;
	
	public void excluir(Integer id) throws SQLException;
	
	public Insumo buscarPeloCodigo(Integer Codigo) throws SQLException;

	void atualizar(InsumosCategorias insumoC ) throws SQLException;

}
