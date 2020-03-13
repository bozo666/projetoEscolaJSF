package escola2020.controlador;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.xml.ws.Action;

import escola2020.servico.EquipamentoServico;
import escola2020.dominio.Equipamentos;
import escola2020.servico.EquipamentoServicoException;
@Named
@RequestScoped
@SuppressWarnings("serial")
public class EquipamentoListaManager implements Serializable {
	private Equipamentos equipamento;
	private EquipamentoServico servico;
	
	public EquipamentoListaManager() {
		this.equipamento = new Equipamentos();
		this.servico = new EquipamentoServico();
	}

	public Equipamentos getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamentos equipamento) {
		this.equipamento = equipamento;
	}
	

	/**
	 * Metodo que retorna todos os elementos cadastrados no BD
	 * @return ArrayList<Usuario> com todos os elementos
	 */
	public ArrayList<Equipamentos> getEquipamentos() {
		try {
			return servico.listar();
		}catch(EquipamentoServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro!",exception.getMessage());
			contexto.addMessage(null, mensagem);
			return null;
		}
	}
	 /** Action, remove um registro do banco de dados a partir de um ID
	 * return String Destino da View
	*/
	@Action
	public String excluir(int codigo) {
		try {
			servico.excluir(codigo);
		} catch (EquipamentoServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",exception.getMessage());
			contexto.addMessage(null, mensagem);			
		}
		return "tabelaEquipamentos.xhtml";
	}
	
	
}
