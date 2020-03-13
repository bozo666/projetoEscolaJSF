package escola2020.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import escola2020.dominio.Cargo;
import escola2020.dominio.Funcionarios;
import escola2020.util.GerenciadorConexao;
import escola2020.util.GerenciadorConexaoMysql;

public class FuncionarioRepositorioImpl implements FuncionarioRepositorio {

	private final GerenciadorConexao gerenciador = GerenciadorConexaoMysql.getInstancia();

	@Override
	public ArrayList<Funcionarios> getAll() throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandosql = "SELECT matricula, cpf, nome, sobrenome, sexo, dtNascimento, email,"
				+ "dtCadastro, status, telefone, endereco, cidade, uf, cep FROM funcionarios ";
		Statement comando = conexao.createStatement();
		ResultSet resultado = comando.executeQuery(comandosql);
		ArrayList<Funcionarios> lista = new ArrayList<>();
		Funcionarios funcionario;
		while (resultado.next()) {
			funcionario = new Funcionarios();
			funcionario.setMatricula(resultado.getString("matricula"));
			funcionario.setCpf(resultado.getString("cpf"));
			funcionario.setNome(resultado.getString("nome"));
			funcionario.setSobrenome(resultado.getString("sobrenome"));
			funcionario.setSexo(resultado.getString("sexo"));
			funcionario.setDataNascimento(resultado.getString("dtNascimento"));
			funcionario.setEmail(resultado.getString("email"));
			funcionario.setDtCadastro(resultado.getDate("dtCadastro"));
			funcionario.setStatus(resultado.getInt("status"));
			funcionario.setTelefone(resultado.getString("telefone"));
			funcionario.setEndereco(resultado.getString("endereco"));
			funcionario.setCidade(resultado.getString("cidade"));
			funcionario.setUf(resultado.getString("uf"));
			funcionario.setCep(resultado.getString("cep"));
			lista.add(funcionario);
		}
		gerenciador.desconectar(conexao);
		return lista;
	}

	@Override
	public void inserir(Funcionarios funcionario) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "INSERT INTO Funcionarios (matricula, cpf, nome, sobrenome, sexo, dtNascimento, email,status, telefone, endereco, cidade, uf, cep,cargos_codigo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setString(1, funcionario.getMatricula());
		comando.setString(2, funcionario.getCpf());
		comando.setString(3, funcionario.getNome());
		comando.setString(4, funcionario.getSobrenome());
		comando.setString(5, funcionario.getSexo());
		comando.setString(6, funcionario.getDataNascimento());
		comando.setString(7, funcionario.getEmail());
		comando.setInt(8, funcionario.getStatus());
		comando.setString(9, funcionario.getTelefone());
		comando.setString(10, funcionario.getEndereco());
		comando.setString(11, funcionario.getCidade());
		comando.setString(12, funcionario.getUf());
		comando.setString(13, funcionario.getCep());
		comando.setInt(14, funcionario.getCargos_codigo());
		comando.executeUpdate();
		gerenciador.desconectar(conexao);

	}

	@Override
	public void atualizar(Funcionarios funcionario) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "UPDATE funcionarios SET matricula=?, nome=?, sobrenome=?, sexo=?, dtNascimento=?, email=?, status=?, telefone=?, endereco=?, cidade=?, uf=?, cep=?,cargos_codigo = ? WHERE  cpf=?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setString(1, funcionario.getMatricula());
		comando.setString(2, funcionario.getNome());
		comando.setString(3, funcionario.getSobrenome());
		comando.setString(4, funcionario.getSexo());
		comando.setString(5, funcionario.getDataNascimento());
		comando.setString(6, funcionario.getEmail());
		comando.setInt(7, funcionario.getStatus());
		comando.setString(8, funcionario.getTelefone());
		comando.setString(9, funcionario.getEndereco());
		comando.setString(10, funcionario.getCidade());
		comando.setString(11, funcionario.getUf());
		comando.setString(12, funcionario.getCep());
		comando.setInt(13, funcionario.getCargos_codigo());
		comando.setString(14, funcionario.getCpf());
		comando.executeUpdate();
		comando.executeUpdate();
		gerenciador.desconectar(conexao);

	}

	@Override
	public void excluir(String cpf) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "DELETE FROM Funcionarios WHERE cpf=?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setString(1, cpf);
		comando.executeUpdate();
		gerenciador.desconectar(conexao);

	}

	@Override
	public Funcionarios get(String matricula) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Cargo>getCargos() throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandosql = "SELECT * FROM cargos";
		Statement comando = conexao.createStatement();
		ResultSet resultado = comando.executeQuery(comandosql);
		ArrayList<Cargo>lista = new ArrayList<>();
		Cargo cargo ;
		while (resultado.next()) {
			cargo = new Cargo();
			cargo.setCodigo(resultado.getInt("codigo"));
			cargo.setNome(resultado.getString("nome"));
			cargo.setDescricao(resultado.getString("descricao"));
			cargo.setCopetencias(resultado.getString("competencias"));
			cargo.setPisoSalarial(resultado.getDouble("pisoSalarial"));
			lista.add(cargo);
		}
		gerenciador.desconectar(conexao);
		return lista;

	}

}
