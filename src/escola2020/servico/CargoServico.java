package escola2020.servico;

import java.sql.SQLException;
import java.util.ArrayList;

import escola2020.dominio.Cargo;
import escola2020.repositorio.CargoRepositorio;
import escola2020.repositorio.CargoRepositorioImpl;

public class CargoServico {

	private CargoRepositorio repositorio;

	public CargoServico() {
		this.repositorio = new CargoRepositorioImpl();
	}

	public ArrayList<Cargo> listar() throws CargoServicoException {
		try {
			return this.repositorio.getAll();
		} catch (Exception exception) {
			throw new CargoServicoException(exception.getMessage());
		}
	}

	public void excluir(Integer id) throws CargoServicoException {
		try {
			this.repositorio.excluir(id);
		} catch (SQLException exception) {
			throw new CargoServicoException(exception.getMessage());
		}
	}

	public void salvar(Cargo cargo) throws CargoServicoException {
		try {
			this.repositorio.inserir(cargo);
		} catch (SQLException exception) {
			throw new CargoServicoException(exception.getMessage());
		}
	}
	public void alterar(Cargo cargo) throws CargoServicoException {
		try {
		this.repositorio.atualizar(cargo);
		} catch (SQLException exception) {
			throw new CargoServicoException(exception.getMessage());
		}

	}
}