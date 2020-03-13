package escola2020.servico;

import java.sql.SQLException;
import java.util.ArrayList;

import escola2020.dominio.Insumo;
import escola2020.repositorio.InsumoRepositorio;
import escola2020.repositorio.InsumoRepositorioImpl;

public class InsumoServico {
	
	public ArrayList<Insumo> executeListarInsumos() throws ExcecaoPersonalizada{
		InsumoRepositorio dao = new InsumoRepositorioImpl();
		try {
			return dao.listarTodos();
		}
		catch(SQLException e) {
			throw new ExcecaoPersonalizada(e.getMessage());
		}
	}
	
	public void executeCadastrar(Insumo insumo) throws ExcecaoPersonalizada{
		InsumoRepositorio dao = new InsumoRepositorioImpl();
		try {
			dao.inserir(insumo);
		}
		catch(SQLException e) {
			throw new ExcecaoPersonalizada(e.getMessage());
		}
	}
	

}
