package escola2020.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import escola2020.dominio.Alunos;
import escola2020.dominio.Sala;
import escola2020.util.GerenciadorConexao;
import escola2020.util.GerenciadorConexaoMysql;

public class SalaRepositorioImpl implements SalaRepositorio {
	private GerenciadorConexao gerenciador;

	public SalaRepositorioImpl() {
		gerenciador = new GerenciadorConexaoMysql();
	}

	@Override
	public void atualizar(Sala sala) throws SQLException {

		Connection conexao = gerenciador.conectar();
		String comandoSql = "UPDATE salas set nome=?, status=?, ocupacaoMax=? WHERE codigo=?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setString(1, sala.getNome());
		comando.setInt(2, sala.getStatus());
		comando.setInt(3, sala.getOcupMax());
		comando.setInt(4, sala.getCodigo());
		comando.executeUpdate();
		gerenciador.desconectar(conexao);
	}
	@Override
	public void inserir(Sala sala) throws SQLException {
		Connection conn = gerenciador.conectar();

		String sql = "INSERT INTO salas (nome, status, OcupacaoMax) VALUES (?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, sala.getNome());
		pst.setInt(2, sala.getStatus());
		pst.setInt(3, sala.getOcupMax());
		pst.executeUpdate();

		gerenciador.desconectar(conn);

	}

	@Override
	public ArrayList<Sala> listarTodas() throws SQLException {
		Connection conn = gerenciador.conectar();

		String sql = "SELECT * FROM salas";
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<Sala> salaList = new ArrayList<>();
		Sala salas;

		while (rs.next()) {
			salas = new Sala();
			salas.setCodigo(rs.getInt("codigo"));
			salas.setNome(rs.getString("nome"));
			salas.setStatus(rs.getInt("status"));
			salas.setOcupMax(rs.getInt("OcupacaoMax"));
			salaList.add(salas);
		}
		gerenciador.desconectar(conn);
		return salaList;
	}

	@Override
	public void excluir(Integer codigo) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "DELETE FROM salas WHERE codigo=?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setInt(1, codigo);
		comando.executeUpdate();
		gerenciador.desconectar(conexao);

	}

	@Override
	public Sala buscarPeloCodigo(Integer Codigo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
