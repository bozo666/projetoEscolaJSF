package escola2020.controlador;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


import escola2020.servico.TurmaServico;
import escola2020.servico.TurmaServicoException;
import escola2020.dominio.*;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class TurmaListaManager implements Serializable {
	private Turma turma;
	private TurmaServico servico;

	public TurmaListaManager() {
		this.turma = new Turma();
		this.servico = new TurmaServico();

	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public String excluir(String codigo) {
		try {
			servico.excluir(codigo);

		} catch (TurmaServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", exception.getMessage());
			contexto.addMessage(null, mensagem);
			
			}
		return null;
		}
	/**
	 * action responsavel por processar os dados para salvar no DB
	 * 
	 * @return String com o retorno da aplicacao(para onde ir)
	 */
	public ArrayList<Turma> getTurmas() {
		try {
			return servico.listar();

		} catch (TurmaServicoException exception) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", exception.getMessage());
			contexto.addMessage(null, mensagem);
			return null;
		}

	}
	
}