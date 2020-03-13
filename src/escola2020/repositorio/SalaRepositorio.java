package escola2020.repositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import escola2020.dominio.Sala;

public interface SalaRepositorio {
	
public void inserir(Sala salas) throws SQLException;
	
	public ArrayList<Sala> listarTodas() throws SQLException;
	
	public void excluir(Integer codigo) throws SQLException;
	
	public Sala buscarPeloCodigo(Integer Codigo) throws SQLException;
	
	public void atualizar(Sala sala) throws SQLException;

}
