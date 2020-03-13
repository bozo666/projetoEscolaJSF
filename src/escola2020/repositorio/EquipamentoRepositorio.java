package escola2020.repositorio;

import java.sql.SQLException;
import java.util.ArrayList;
import escola2020.dominio.Equipamentos;

public interface EquipamentoRepositorio {

public void inserir(Equipamentos equipamento) throws SQLException;
	
	public void atualizar(Equipamentos equipamento) throws SQLException;
	
	public void excluir(int codigo) throws SQLException;

	public Equipamentos get(int codigo) throws SQLException;
		/**
	 * Retorna um vetor com todos os registros do BD
	 * @return ArrayList<Usuario> com todos os registros, ou um objeto vazio
	 * @throws SQLException
	 */
	public ArrayList<Equipamentos> getAll() throws SQLException;
}

