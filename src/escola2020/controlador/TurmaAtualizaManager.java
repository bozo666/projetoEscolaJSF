package escola2020.controlador;
import java.io.Serializable;


import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import escola2020.dominio.Turma;
import escola2020.servico.TurmaServico;
import escola2020.servico.TurmaServicoException;


@SuppressWarnings("serial")
@Named
@SessionScoped
public class TurmaAtualizaManager implements Serializable {
	private Turma turma;
	private TurmaServico servico;

	public TurmaAtualizaManager() {
		this.turma=new Turma();
		this.servico=new TurmaServico();
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	/**
	 * action responsavel por processar os dados para salvar no DB
	 * @return String com o retorno da aplicacao(para onde ir)
	 * 
	 */
	public String alterar(Turma turma) {
	this.turma=turma;
	return "atualizaTurma.xhtml";
	}
	
	public String salvar() {
	try {		
			servico.alterar(turma);
			
	} catch (TurmaServicoException exception) {
			FacesContext contexto=FacesContext.getCurrentInstance();
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro",exception.getMessage());
			contexto.addMessage(null, mensagem);
			return null;
		}
		return "tabelaTurma.xhtml";
	}

	}

