package escola2020.dominio;

import java.util.Date;

public class Funcionarios {

	private String matricula;

	private String cpf;

	private String nome;
	private String sobrenome;

	private String sexo;

	private String dataNascimento;

	private String email;

	private Date dtCadastro;

	private int status;

	private String telefone;

	private String endereco;

	private String cidade;

	private String uf;

	private String cep;

	private int cargos_codigo;

	public Funcionarios() {

	}

	public Funcionarios(String matricula, String cpf, String nome, String sobrenome, String sexo, String dataNascimento,
			String email, int status, String telefone, String endereco, String cidade, String uf, String cep,
			int cargos_codigo) {
		super();
		this.matricula = matricula;
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.status = status;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.cargos_codigo = cargos_codigo;

	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getCargos_codigo() {
		return cargos_codigo;
	}

	public void setCargos_codigo(int cargos_codigo) {
		this.cargos_codigo = cargos_codigo;
	}

}
