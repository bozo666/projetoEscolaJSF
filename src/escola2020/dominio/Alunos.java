package escola2020.dominio;

import java.security.Timestamp;
import java.util.Date;  

import javax.validation.constraints.NotNull;

public class Alunos {
	@NotNull	
	private String matricula;
	@NotNull
	private String cpf;
	@NotNull
	private String nome;
	@NotNull
	private String sobrenome;
	@NotNull
	private String sexo;
	@NotNull
	private String dtNascimento;
	@NotNull
	private String email;
	@NotNull
	private Timestamp dtCadastro;
	@NotNull
	private int temNecessidadeEspecial;

	@NotNull
	private int status;
	private String telefone;
	private String endereco;
	private String cidade;
	private String uf;
	private String cep;
	
	public Alunos() {
		
		
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

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String localdate) {
		this.dtNascimento = localdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Timestamp dtCadastro) {
		this.dtCadastro=dtCadastro;
	}

	public int getTemNecessidadeEspecial() {
		return temNecessidadeEspecial;
	}

	public void setTemNecessidadeEspecial(int temNecessidadeEspecial) {
		this.temNecessidadeEspecial = temNecessidadeEspecial;
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

	
	
	
}
