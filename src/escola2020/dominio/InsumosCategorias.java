package escola2020.dominio;

import javax.validation.constraints.NotNull;

public class InsumosCategorias {

	@NotNull
	private int codigo;
	@NotNull
	private String nome;
	@NotNull
	private int status = 1;
	
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
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
