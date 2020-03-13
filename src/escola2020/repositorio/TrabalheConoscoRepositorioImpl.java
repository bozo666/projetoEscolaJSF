package escola2020.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import escola2020.dominio.*;
import escola2020.util.GerenciadorConexao;
import escola2020.util.GerenciadorConexaoMysql;

@SuppressWarnings("unused")
public class TrabalheConoscoRepositorioImpl implements TrabalheConoscoRepositorio {
	private GerenciadorConexao gerenciador;

	public TrabalheConoscoRepositorioImpl() {
		gerenciador = new GerenciadorConexaoMysql();
	}

	@Override
	public void inserir(TrabalheConosco trabalheConosco) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "INSERT INTO trabalheconosco (nome,email,telefone,curriculo) VALUES (?,?,?,?)";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setString(1, trabalheConosco.getNome());
		comando.setString(2, trabalheConosco.getEmail());
		comando.setString(3, trabalheConosco.getTelefone());
		comando.setString(4, trabalheConosco.getCurriculo());
		comando.executeUpdate();
		gerenciador.desconectar(conexao);

	}

	@Override
	public void atualizar(TrabalheConosco trabalheConosco) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "UPDATE trabalheconosco SET nome=?,email=?,telefone=?,curriculo=? WHERE id=?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setString(1, trabalheConosco.getNome());
		comando.setString(2, trabalheConosco.getEmail());
		comando.setString(3, trabalheConosco.getTelefone());
		comando.setString(4, trabalheConosco.getCurriculo());
		comando.setInt(5, trabalheConosco.getId());
		comando.executeUpdate();
		gerenciador.desconectar(conexao);

	}

	@Override
	public void excluir(int id) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "DELETE FROM trabalheconosco WHERE id=?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setInt(1, id);
		comando.executeUpdate();
		gerenciador.desconectar(conexao);

	}

//	@Override
//	public TrabalheConosco get(String email) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public ArrayList<TrabalheConosco> getAll() throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "SELECT * FROM trabalheconosco";
		Statement comando = conexao.createStatement();
		ResultSet resultado = comando.executeQuery(comandoSql);
		ArrayList<TrabalheConosco> lista = new ArrayList<>();
		while (resultado.next()) {
			TrabalheConosco trabalheConosco = new TrabalheConosco();
			trabalheConosco.setId(resultado.getInt("id"));
			trabalheConosco.setNome(resultado.getString("nome"));
			trabalheConosco.setEmail(resultado.getString("email"));
			trabalheConosco.setTelefone(resultado.getString("telefone"));
			trabalheConosco.setCurriculo(resultado.getString("curriculo"));
			lista.add(trabalheConosco);

		}
		gerenciador.desconectar(conexao);
		return lista;
	}

}
