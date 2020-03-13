package escola2020.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import escola2020.dominio.Insumo;
import escola2020.dominio.InsumosCategorias;
import escola2020.util.GerenciadorConexao;
import escola2020.util.GerenciadorConexaoMysql;

public class InsumoRepositorioImpl implements InsumoRepositorio {
	private GerenciadorConexao gerenciador;

	public InsumoRepositorioImpl() {
		gerenciador = new GerenciadorConexaoMysql();
	}

	@Override
	public void inserir(Insumo insumo) throws SQLException {
		Connection conn = gerenciador.conectar();

		String sql = "INSERT INTO insumos (nome, descricao, status, qtdeMinima, qtdeMaxima, qtdeAtual) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, insumo.getNome());
		pst.setString(2, insumo.getDescricao());
		pst.setInt(3, insumo.getStatus());
		pst.setDouble(4, insumo.getQtdeAtual());
		pst.setDouble(5, insumo.getQtdeMinima());
		pst.setDouble(6, insumo.getQtdeMaxima());
		pst.setInt(7, insumo.getCategorias().getCodigo());
		pst.executeUpdate();

		gerenciador.desconectar(conn);
	}


	@Override
	public ArrayList<Insumo> listarTodos() throws SQLException {
		Connection conn = gerenciador.conectar();

		String sql = "SELECT * FROM insumos";
		Statement stm = conn.createStatement();

		ResultSet rs = stm.executeQuery(sql);
		ArrayList<Insumo> InsumosList = new ArrayList<>();
		Insumo insumos;

		while (rs.next()) {
			insumos = new Insumo();
			insumos.setCodigo(rs.getInt("codigo"));
			insumos.setNome(rs.getString("nome"));
			insumos.setDescricao(rs.getString("descricao"));
			insumos.setStatus(rs.getInt("status"));
			insumos.setQtdeMinima(rs.getDouble("qtdeMinima"));
			insumos.setQtdeMaxima(rs.getDouble("qtdeMaxima"));
			insumos.setQtdeAtual(rs.getDouble("qtdeAtual"));

			InsumosCategorias categoria = new InsumosCategorias();
			categoria.setNome(rs.getString("nome"));
			// categoria.setCodigo(rs.getInt("InsumoCategorias_codigo"));

			insumos.setCategorias(categoria);
			InsumosList.add(insumos);
		}
		gerenciador.desconectar(conn);
		return InsumosList;
	}

	@Override
	public void excluir(Integer id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Insumo buscarPeloCodigo(Integer Codigo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
