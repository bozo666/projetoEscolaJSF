package escola2020.controlador;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.Cargo;
import escola2020.servico.CargoServico;
import escola2020.servico.CargoServicoException;
import escola2020.servico.FuncionarioServicoException;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class CargoAtualizaManager implements Serializable {

	private Cargo cargo;
	private CargoServico servico;

	public CargoAtualizaManager() {
		this.cargo = new Cargo();
		this.servico = new CargoServico();
	}

	public CargoServico getServico() {
		return servico;
	}

	public void setServico(CargoServico servico) {
		this.servico = servico;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	/**
	 * Action responsavel por processar os dados para salvar no BD
	 * 
	 * @return string com o destino da aplicação (para onde ir)
	 */
	public String alterar(Cargo obj) {
		this.cargo = obj;
		return "atualizaCargo.xhtml";
	}

	public String atualizar() throws CargoServicoException {
		try {
			servico.alterar(this.cargo);
		} catch (CargoServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!" + exception.getMessage(), "");
			contexto.addMessage(null, mensagem);
			return null;
		}
		return "tabelaCargos.xhtml";
	}
}