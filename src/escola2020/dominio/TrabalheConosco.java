package escola2020.dominio;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class TrabalheConosco {
	private int id;
	@NotNull
	private String nome;
	@NotNull
	@Email
	private String email;
	@NotNull
	private String telefone;
	@NotNull
	private String curriculo;

	public TrabalheConosco() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}

}
