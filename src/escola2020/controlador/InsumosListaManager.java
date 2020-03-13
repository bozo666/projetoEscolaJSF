package escola2020.controlador;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.Insumo;
import escola2020.servico.ExcecaoPersonalizada;
import escola2020.servico.InsumoServico;

@SuppressWarnings("serial")
@Named @RequestScoped
public class InsumosListaManager implements Serializable {
	
	private Insumo insumo;
	private InsumoServico serviceInsumos;
	
	public InsumosListaManager () {
		serviceInsumos = new InsumoServico();
		insumo = new Insumo();
	}
	
	public Insumo getInsumo() {
		return insumo;
	}
	public void setInsumos(Insumo insumo) {
		this.insumo = insumo;
	}
	public InsumoServico getServiceInsumos() {
		return serviceInsumos;
	}
	public void setServiceInsumos(InsumoServico serviceInsumos) {
		this.serviceInsumos = serviceInsumos;
	}
	
	public ArrayList<Insumo> getInsumos() {
		try {
			return serviceInsumos.executeListarInsumos();
		}catch (ExcecaoPersonalizada e) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO!", e.getMessage());
			context.addMessage(null, msg);
			return null;
		}
	}
	
	

}
