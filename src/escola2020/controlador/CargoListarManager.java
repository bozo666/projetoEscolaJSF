package escola2020.controlador;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.Cargo;
import escola2020.servico.CargoServico;
import escola2020.servico.CargoServicoException;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class CargoListarManager implements Serializable {

	private Cargo funcionario;
	private CargoServico servico;

	public CargoListarManager() {
		this.setCargo(new Cargo());
		this.servico = new CargoServico();
	}

	public Cargo getCargo() {
		return funcionario;
	}

	public void setCargo(Cargo funcionario) {
		this.funcionario = funcionario;
	}

	public ArrayList<Cargo> getCargos() {
		try {
			return servico.listar();
		} catch (CargoServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO :" + exception.getMessage(),
					"");
			contexto.addMessage(null, mensagem);
			return (new ArrayList<Cargo>());
		}

	}

	public String excluir(Integer id) {
		try {
			servico.excluir(id);
		} catch (CargoServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", exception.getMessage());
			contexto.addMessage(null, mensagem);
		}
		return "tabelaCargos.xhtml";
	}

	public String redirecionaCadastro() {
		return "registroCargos.xhtml";
	}

}
