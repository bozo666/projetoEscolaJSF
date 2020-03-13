package escola2020.servico;

import escola2020.repositorio.EquipamentoRepositorio;
import escola2020.repositorio.EquipamentoRepositorioImpl;
import escola2020.dominio.Equipamentos;

import java.sql.SQLException;
import java.util.ArrayList;

public class EquipamentoServico {
private EquipamentoRepositorio repositorio;
	
	public EquipamentoServico(){
		this.repositorio = new EquipamentoRepositorioImpl();
	}
	
	/**
	 * Valida e salva um equipamento no BD
	 * @param usuario Objeto contendo todos os dados para inclusão
	 */
	public void salvar(Equipamentos equipamento) throws EquipamentoServicoException{
		try {
			this.repositorio.inserir(equipamento);
		} catch (SQLException exception) {
			throw new EquipamentoServicoException(exception.getMessage());
		}
	}
	
	/**
	 * Retorna um vetor com todos os dados do BD
	 * @return arraylist de usuario com os elementos encontrados
	 * @throws UsuarioServicoException
	 */
	public ArrayList<Equipamentos> listar() throws EquipamentoServicoException{
		try {
			return this.repositorio.getAll();
		} catch (Exception exception) {
			throw new EquipamentoServicoException(exception.getMessage());
		}
	}
	
	/**
	 * Valida e exclui um usuário no BD
	 * @param ID identificador do registro a ser exluido
	 */
	public void excluir(int codigo) throws EquipamentoServicoException{
		try {
			this.repositorio.excluir(codigo);
		} catch (SQLException exception) {
			throw new EquipamentoServicoException(exception.getMessage());
		}
	}
	/**
	 * Valida e salva uma atualização do usuário no BD
	 * @param usuario Objeto contendo todos os dados para inclusao, inclusive o ID
	 */
	public void alterar(Equipamentos equipamento) throws EquipamentoServicoException{
		try {
			this.repositorio.atualizar(equipamento);
		} catch (SQLException exception) {
			throw new EquipamentoServicoException(exception.getMessage());
		}
	}
}
