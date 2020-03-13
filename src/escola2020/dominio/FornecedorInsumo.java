package escola2020.dominio;

import javax.validation.constraints.NotNull;

public class FornecedorInsumo {

	@NotNull
	private int fornecedores_codigo;
	@NotNull
	private int insumos_codigo;
	private Fornecedor fornecedor;
	private Insumo insumo;
	
	public FornecedorInsumo() {
		this.fornecedor=new Fornecedor();
		this.insumo =new Insumo();
	}
	
	public int getFornecedores_codigo() {
		return fornecedor.getCodigo();
	}
	public void setFornecedores_codigo(int fornecedores_codigo) {
		this.fornecedor.setCodigo(fornecedores_codigo);
	}
	public int getInsumos_codigo() {
		return insumo.getCodigo();
	}
	public void setInsumos_codigo(int insumos_codigo) {
		this.insumo.setCodigo(insumos_codigo);
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Insumo getInsumo() {
		return insumo;
	}
	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	
	
	
	
	
}
