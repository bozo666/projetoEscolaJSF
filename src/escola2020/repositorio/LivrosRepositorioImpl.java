package escola2020.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import escola2020.dominio.Livros;
import escola2020.util.GerenciadorConexao;
import escola2020.util.GerenciadorConexaoMysql;

public class LivrosRepositorioImpl implements LivrosRepositorio {

	private final GerenciadorConexao gerenciador = GerenciadorConexaoMysql.getInstancia();

	@Override
	public void inserir(Livros livros) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "INSERT INTO livros1 (nome, categoria, autor, codigo, editora) VALUES (?,?,?,?,?)";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setString(1, livros.getNome());
		comando.setString(2, livros.getCategoria());
		comando.setString(3, livros.getAutor());
		comando.setInt(4, livros.getCodigo());
		comando.setString(5, livros.getEditora());
		comando.executeUpdate();
		gerenciador.desconectar(conexao);
	}

	@Override
	public void atualizar(Livros livros) throws SQLException {

		Connection conexao = gerenciador.conectar();
		String comandoSql = "UPDATE livros1 SET nome=?, categoria=?, autor=?, editora=? WHERE codigo=?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setString(1, livros.getNome());
		comando.setString(2, livros.getCategoria());
		comando.setString(3, livros.getAutor());
		comando.setInt(5, livros.getCodigo());
		comando.setString(4, livros.getEditora());
		comando.executeUpdate();
		gerenciador.desconectar(conexao);
	}

	@Override
	public Livros get(String livro) throws SQLException {

		return null;

	}

	@Override
	public void excluir(Integer codigo) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "DELETE FROM livros1 WHERE codigo=?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setInt(1, codigo);
		comando.executeUpdate();
		gerenciador.desconectar(conexao);

	}

	public Livros get(Integer codigo) throws SQLException {
		return null;
	}

	@Override
	public ArrayList<Livros> getAll() throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandosql = "SELECT * FROM livros1";
		Statement comando = conexao.createStatement();
		ResultSet resultado = comando.executeQuery(comandosql);
		ArrayList<Livros> lista = new ArrayList<>();
		Livros livro;

		while (resultado.next()) {
			livro = new Livros();
			livro.setNome(resultado.getString("nome"));
			livro.setCategoria(resultado.getString("categoria"));
			livro.setAutor(resultado.getString("autor"));
			livro.setCodigo(resultado.getInt("codigo"));
			livro.setEditora(resultado.getString("editora"));
			lista.add(livro);

		}

		gerenciador.desconectar(conexao);
		return lista;
	}

}
