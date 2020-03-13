package escola2020.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import escola2020.dominio.Cargo;
import escola2020.util.GerenciadorConexao;
import escola2020.util.GerenciadorConexaoMysql;

public class CargoRepositorioImpl implements CargoRepositorio {

	private final GerenciadorConexao gerenciador = GerenciadorConexaoMysql.getInstancia();

	@Override
	public ArrayList<Cargo> getAll() throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandosql = "SELECT * FROM cargos";
		Statement comando = conexao.createStatement();
		ResultSet resultado = comando.executeQuery(comandosql);
		ArrayList<Cargo> lista = new ArrayList<>();
		Cargo cargo;
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

	@Override
	public Cargo get(String matricula) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Integer id) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "DELETE FROM Cargos WHERE codigo =?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setInt(1, id);
		comando.executeUpdate();
		gerenciador.desconectar(conexao);

	}

	@Override
	public void inserir(Cargo cargo) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "INSERT INTO Cargos (nome,descricao,competencias,pisoSalarial) VALUES (?,?,?,?)";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setString(1, cargo.getNome());
		comando.setString(2, cargo.getDescricao());
		comando.setString(3, cargo.getCopetencias());
		comando.setDouble(4, cargo.getPisoSalarial());
		comando.executeUpdate();
		gerenciador.desconectar(conexao);
		
	}
	@Override
	public void atualizar(Cargo cargo) throws SQLException {
		
		Connection conexao = gerenciador.conectar();
		String comandoSql = "UPDATE cargos SET nome=?,descricao = ?,competencias = ?,pisoSalarial =? WHERE  codigo =?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setString(1, cargo.getNome());
		comando.setString(2, cargo.getDescricao());
		comando.setString(3, cargo.getCopetencias());
		comando.setDouble(4, cargo.getPisoSalarial());
		comando.setInt(5, cargo.getCodigo());
		comando.executeUpdate();
		gerenciador.desconectar(conexao);
	}

}
