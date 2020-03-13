package escola2020.dominio;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class Equipamentos {
	@NotNull
	private int codigo;
	@NotNull
	private String numeroOrdem;
	@NotNull
	private String  nome;
	@NotNull
	private  String descricao;
	@NotNull
	private String marca;
	@NotNull
	private String dtAquisicao;
	@NotNull
	private Double valorCompra;
	@NotNull
	private int status;
	
	private String statusString;
	
	private Sala salas;
	@NotNull
	private int Salas_codigo;
	
	private String SalasTexto;

	public Equipamentos() {
		this.salas = new Sala();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNumeroOrdem() {
		return numeroOrdem;
	}
	public void setNumeroOrdem(String numeroOrdem) {
		this.numeroOrdem = numeroOrdem;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

	
	public String getDtAquisicao() {
		return dtAquisicao;
	}
	public void setDtAquisicao(String dtAquisicao) {
		this.dtAquisicao = dtAquisicao;
	}
	public Double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Sala getSalas() {
		return salas;
	}
	public void setSalas(Sala salas) {
		this.salas = salas;
	}
	public int getSalas_codigo() {
		return Salas_codigo;
	}
	public void setSalas_codigo(int salas_codigo) {
		Salas_codigo = salas_codigo;
	}
	public String getStatusString() {
		if(status==0) return "Encerrada";
		if(status==1) return "Ativa";
		if(status==2) return "Confirmada";
		if(status==3) return "Em Formação";
		if(status==4) return "Cancelada";	
		if(status==5) return "Suspensa";
		return statusString;
	}
	
	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}
	public String getSalasTexto() {
		if(Salas_codigo==123) return "Sala A";
		return SalasTexto;
	}
	public void setSalasTexto(String salasTexto) {
		SalasTexto = salasTexto;
	}
	
	
	
}
