package escola2020.controlador;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


import escola2020.dominio.CalendarioLetivo;
import escola2020.servico.AlunoServicoException;
import escola2020.servico.CalendarioServico;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class CalendarioLetivoCadastroManager implements Serializable{
	
		private CalendarioLetivo calendario;
		private CalendarioServico servico;
		
		public CalendarioLetivoCadastroManager() {
			this.calendario = new CalendarioLetivo();
			this.servico = new CalendarioServico();
		}

		public CalendarioLetivo getCalendario() {
			return calendario;
		}


		public void setCalendario(CalendarioLetivo calendario) {
			this.calendario = calendario;
		}


		public CalendarioServico getServico() {
			return servico;
		}


		public void setServico(CalendarioServico servico) {
			this.servico = servico;
		}


		/**
		 * Action responsavel por processar os dados para salvar no BD
		 * @return string com o destino da aplicação (para onde ir)
		 */
		public String salvar() {
			try {
				servico.salvar(this.calendario);
			} catch (AlunoServicoException exception) {
				FacesContext contexto = FacesContext.getCurrentInstance();
				FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",exception.getMessage());
				contexto.addMessage(null, mensagem);			
				return null;
			}
			return "Calendario.xhtml";
		}
		
		public String irPaginaCadastrar() {
			return "registroCalendario.xhtml";
		}
		public String irPaginaListar() {
			return "Calendario.xhtml";
		}

	}
