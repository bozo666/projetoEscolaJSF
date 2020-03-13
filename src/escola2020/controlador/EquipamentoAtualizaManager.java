package escola2020.controlador;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.Equipamentos;
import escola2020.servico.EquipamentoServico;
import escola2020.servico.EquipamentoServicoException;
@SuppressWarnings("serial")
@Named
@SessionScoped
public class EquipamentoAtualizaManager implements Serializable {


	private Equipamentos equipamento;
	private EquipamentoServico servico;
	
	public EquipamentoAtualizaManager() {
		this.equipamento = new Equipamentos();
		this.servico = new EquipamentoServico();
	}

	public EquipamentoServico getServico() {
		return servico;
	}

	public void setServico(EquipamentoServico servico) {
		this.servico = servico;
	}

	public Equipamentos getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamentos equipamento) {
		this.equipamento = equipamento;
	}
	
	/**
	 * Action responsavel por processar os dados para salvar no BD
	 * @return string com o destino da aplicação (para onde ir)
	 */
	public String alterar(Equipamentos equipamento){
			this.equipamento=equipamento;
			return "atualizaEquipamento.xhtml";
	}
	
	public String salvar (){
				try {
			servico.alterar(this.equipamento);
		} catch (EquipamentoServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!" + exception.getMessage(),"");
			contexto.addMessage(null, mensagem);			
			return null;
		}
		return "tabelaEquipamentos.xhtml";
	}

}