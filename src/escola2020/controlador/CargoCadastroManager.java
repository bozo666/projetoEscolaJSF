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

@SuppressWarnings("serial")
@Named
@RequestScoped
public class CargoCadastroManager implements Serializable {

	private Cargo funcionario;
	private CargoServico servico;

	public CargoCadastroManager() {
		this.setCargo(new Cargo());
		this.servico = new CargoServico();
	}

	public Cargo getCargo() {
		return funcionario;
	}

	public void setCargo(Cargo funcionario) {
		this.funcionario = funcionario;
	}

	public String salvar() {
		try {
			servico.salvar(this.funcionario);
		} catch (CargoServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!" + exception.getMessage(), "");
			contexto.addMessage(null, mensagem);
			return null;
		}
		return "tabelaCargos.xhtml";
	}

	public String irPaginaCadastrar() {
		return "registroCargos.xhtml";
	}
	
	public String irPaginaListar() {
		return "tabelaCargos.xhtml";
	}

}
