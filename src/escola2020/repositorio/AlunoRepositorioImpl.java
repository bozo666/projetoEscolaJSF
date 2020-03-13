package escola2020.repositorio;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Date;

import escola2020.dominio.Alunos;
import escola2020.util.GerenciadorConexao;
import escola2020.util.GerenciadorConexaoMysql;

public class AlunoRepositorioImpl implements AlunoRepositorio {

	private final GerenciadorConexao gerenciador = GerenciadorConexaoMysql.getInstancia();

	@Override
	public void inserir(Alunos aluno) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "INSERT INTO alunos (matricula, cpf, nome, sobrenome, sexo, dtNascimento, email,temNecessidadeEspecial, status, telefone, endereco, cidade, uf, cep) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setString(1, aluno.getMatricula());
		comando.setString(2, aluno.getCpf());
		comando.setString(3, aluno.getNome());
		comando.setString(4, aluno.getSobrenome());
		comando.setString(5, aluno.getSexo());
		comando.setString(6, aluno.getDtNascimento());
		comando.setString(7, aluno.getEmail());
		comando.setInt(8, aluno.getTemNecessidadeEspecial());
		comando.setInt(9, aluno.getStatus());
		comando.setString(10, aluno.getTelefone());
		comando.setString(11, aluno.getEndereco());
		comando.setString(12, aluno.getCidade());
		comando.setString(13, aluno.getUf());
		comando.setString(14, aluno.getCep());
		comando.executeUpdate();
		gerenciador.desconectar(conexao);
	}

	@Override
	public void atualizar(Alunos aluno) throws SQLException {

		Connection conexao = gerenciador.conectar();
		String comandoSql = "UPDATE alunos set cpf=?, nome=?, sobrenome=?, sexo=?, dtNascimento=?, email=?, temNecessidadeEspecial=?, status=?, telefone=?, endereco=?, cidade=?, uf=?, cep=? WHERE matricula=?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setString(1, aluno.getCpf());
		comando.setString(2, aluno.getNome());
		comando.setString(3, aluno.getSobrenome());
		comando.setString(4, aluno.getSexo());
		comando.setString(5, aluno.getDtNascimento());
		comando.setString(6, aluno.getEmail());
		comando.setInt(7, aluno.getTemNecessidadeEspecial());
		comando.setInt(8, aluno.getStatus());
		comando.setString(9, aluno.getTelefone());
		comando.setString(10, aluno.getEndereco());
		comando.setString(11, aluno.getCidade());
		comando.setString(12, aluno.getUf());
		comando.setString(13, aluno.getCep());
		comando.setString(14, aluno.getMatricula());
		comando.executeUpdate();
		gerenciador.desconectar(conexao);
	}

	@Override
	public void excluir(String matricula) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "DELETE FROM alunos WHERE matricula=?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setString(1, matricula);
		comando.executeUpdate();
		gerenciador.desconectar(conexao);
	}

	@Override
	public Alunos get(String matricula) throws SQLException {
		return null;
	}

	@Override
	public ArrayList<Alunos> getAll() throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandosql = "SELECT matricula, cpf, nome, sobrenome, sexo, dtNascimento, email,temNecessidadeEspecial, status, telefone, endereco, cidade, uf, cep FROM alunos ";
		Statement comando = conexao.createStatement();
		ResultSet resultado = comando.executeQuery(comandosql);
		ArrayList<Alunos> lista = new ArrayList<>();
		Alunos aluno;
		while (resultado.next()) {
			aluno = new Alunos();
			aluno.setMatricula(resultado.getString("matricula"));
			aluno.setCpf(resultado.getString("cpf"));
			aluno.setNome(resultado.getString("nome"));
			aluno.setSobrenome(resultado.getString("sobrenome"));
			aluno.setSexo(resultado.getString("sexo"));
			aluno.setDtNascimento(resultado.getString("dtNascimento"));
			aluno.setEmail(resultado.getString("email"));
			aluno.setTemNecessidadeEspecial(resultado.getInt("temNecessidadeEspecial"));
			aluno.setStatus(resultado.getInt("status"));
			aluno.setTelefone(resultado.getString("telefone"));
			aluno.setEndereco(resultado.getString("endereco"));
			aluno.setCidade(resultado.getString("cidade"));
			aluno.setUf(resultado.getString("uf"));
			aluno.setCep(resultado.getString("cep"));
			lista.add(aluno);
		}
		gerenciador.desconectar(conexao);
		return lista;
	}

}
