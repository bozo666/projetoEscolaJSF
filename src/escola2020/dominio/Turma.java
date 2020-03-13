package escola2020.dominio;


import javax.validation.constraints.NotNull;

public class Turma {
	
	@NotNull(message = "Codigo invalido")
	private String codigo;
	@NotNull(message = "Nome invalido")
	private String nome;
	@NotNull(message = "Status invalido")
	private int status;
	@NotNull(message = "Data inicial invalida")
	private String dtInicio;
	@NotNull(message = "Data final invalida")
	private String dtFim;
	@NotNull(message = "Turno invalido")
	private String turno;
	@NotNull(message = "Codigo de Curso invalido")	
	private int Cursos_codigo;
	private String cursosTexto;
	private String statusTexto;
	
	
	

	public Turma() {
		//Turma turma = new Turma();		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getStatus() {
		return status;
	
	}

	
	

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(String dtInicio) {
		this.dtInicio = dtInicio;
	}

	public String getDtFim() {
		return dtFim;
	}

	public void setDtFim(String dtFim) {
		this.dtFim = dtFim;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public int getCursos_codigo() {		
		return Cursos_codigo;
	}

	public void setCursos_codigo(int cursos_codigo) {
		Cursos_codigo = cursos_codigo;
	}

	public String getCursosTexto() {
		if(Cursos_codigo==1) return "Fisica";
		return cursosTexto;
	}

	public void setCursosTexto(String cursosTexto) {
		this.cursosTexto = cursosTexto;
	}

	public String getStatusTexto() {
		if(status==0) return "Encerrada";
		if(status==1) return "Ativa";
		if(status==2) return "Confirmada";
		if(status==3) return "Em Formação";
		if(status==4) return "Cancelada";	
		if(status==5) return "Suspensa";
		return statusTexto;
	}

	public void setStatusTexto(String statusTexto) {
		this.statusTexto = statusTexto;
	}
	
	
}
