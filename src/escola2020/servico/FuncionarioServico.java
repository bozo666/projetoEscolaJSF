package escola2020.servico;

import java.sql.SQLException;
import java.util.ArrayList;

import escola2020.dominio.Cargo;
import escola2020.dominio.Funcionarios;
import escola2020.repositorio.FuncionarioRepositorio;
import escola2020.repositorio.FuncionarioRepositorioImpl;

public class FuncionarioServico {

	private FuncionarioRepositorio repositorio;

	public FuncionarioServico() {
		this.repositorio = new FuncionarioRepositorioImpl();
	}

	/**
	 * Valida e salva um funcionario no BD
	 * 
	 * @param usuario Objeto contendo todos os dados para inclusão
	 */
	public void salvar(Funcionarios funcionario) throws FuncionarioServicoException {
		try {
			this.repositorio.inserir(funcionario);
		} catch (SQLException exception) {
			throw new FuncionarioServicoException(exception.getMessage());
		}
	}

	/**
	 * Retorna um vetor com todos os dados do BD
	 * 
	 * @return arraylist de Funcionario com os elementos encontrados
	 * @throws FuncionarioServicoException
	 * 
	 */
	public ArrayList<Funcionarios> listar() throws FuncionarioServicoException {
		try {
			return this.repositorio.getAll();
		} catch (Exception exception) {
			throw new FuncionarioServicoException(exception.getMessage());
		}
	}

	public void excluir(String cpf) throws FuncionarioServicoException {
		try {
			this.repositorio.excluir(cpf);
		} catch (SQLException exception) {
			throw new FuncionarioServicoException(exception.getMessage());
		}
	}

	public void alterar(Funcionarios funcionario) throws FuncionarioServicoException {
		try {
			this.repositorio.atualizar(funcionario);
		} catch (SQLException exception) {
			throw new FuncionarioServicoException(exception.getMessage());
		}

	}

	public ArrayList<Cargo> listarCargos() throws FuncionarioServicoException {
		try {
			return this.repositorio.getCargos();
		} catch (Exception exception) {
			throw new FuncionarioServicoException(exception.getMessage());
		}
	}
}
