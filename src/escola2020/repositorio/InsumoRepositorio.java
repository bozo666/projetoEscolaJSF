package escola2020.repositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import escola2020.dominio.Insumo;

public interface InsumoRepositorio {
	
	public void inserir(Insumo insumo) throws SQLException;
	
	public ArrayList<Insumo> listarTodos() throws SQLException;
	
	public void excluir(Integer id) throws SQLException;
	
	public Insumo buscarPeloCodigo(Integer Codigo) throws SQLException;


}
