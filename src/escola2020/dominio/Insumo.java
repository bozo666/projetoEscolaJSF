package escola2020.dominio;

import javax.validation.constraints.NotNull;

public class Insumo {

	private int codigo;
	@NotNull(message = "Nome nao pode ser nulo")
	private String nome;
	@NotNull(message = "Descrição nao pode ser nulo")
	private String descricao;
	@NotNull(message = "status nao pode ser nulo")
	private int status;
	@NotNull(message = "Quantidade min nao pode ser nulo")
	private Double qtdeMinima;
	@NotNull(message = "Quantidade max nao pode ser nulo")
	private Double qtdeMaxima;
	@NotNull(message = "Quantidade atual nao pode ser nulo")
	private Double qtdeAtual;
	
	private InsumosCategorias categorias;
	
	public Insumo() {
		this.categorias = new InsumosCategorias();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Double getQtdeMinima() {
		return qtdeMinima;
	}

	public void setQtdeMinima(Double qtdeMinima) {
		this.qtdeMinima = qtdeMinima;
	}

	public Double getQtdeMaxima() {
		return qtdeMaxima;
	}

	public void setQtdeMaxima(Double qtdeMaxima) {
		this.qtdeMaxima = qtdeMaxima;
	}

	public Double getQtdeAtual() {
		return qtdeAtual;
	}

	public void setQtdeAtual(Double qtdeAtual) {
		this.qtdeAtual = qtdeAtual;
	}

	public InsumosCategorias getCategorias() {
		return categorias;
	}

	public void setCategorias(InsumosCategorias categorias) {
		this.categorias = categorias;
	}

	
	
	
}
