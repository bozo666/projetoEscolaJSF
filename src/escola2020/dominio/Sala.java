package escola2020.dominio;

import javax.validation.constraints.NotNull;

public class Sala {
	
	@NotNull
	private int codigo;
	@NotNull
	private String nome;
	@NotNull
	private int status;
	@NotNull
	private int ocupMax;
	
	public int getOcupMax() {
		return ocupMax;
	}
	public void setOcupMax(int ocupMax) {
		this.ocupMax = ocupMax;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getStatus() {
		return this.status;
	}
	public String getStatusStr() {
		if(this.status==0) return "Inativo";
		if(this.status==1) return "Ativo";
		if(this.status==2) return "Em manutenção";
		if(this.status==3) return "Indisponível";
		return null;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
