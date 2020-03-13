package escola2020.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import escola2020.dominio.Fornecedor;
import escola2020.dominio.Insumo;
import escola2020.dominio.InsumosCategorias;
import escola2020.util.GerenciadorConexao;
import escola2020.util.GerenciadorConexaoMysql;

public class InsumoCategoriaRepositorioImpl implements InsumoCategoriaRepositorio {
	
	private GerenciadorConexao gerenciador;
	
	public InsumoCategoriaRepositorioImpl() {
		gerenciador = new GerenciadorConexaoMysql();
	}

	@Override
	public void inserir(InsumosCategorias insumoC) throws SQLException {
		Connection conn = gerenciador.conectar();

		String sql = "INSERT INTO insumocategorias (nome, status) VALUES (?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, insumoC.getNome());
		pst.setInt(2, insumoC.getStatus());
		pst.executeUpdate();

		gerenciador.desconectar(conn);
		
	}

	@Override
	public ArrayList<InsumosCategorias> listarTodos() throws SQLException {
		
		Connection conn = gerenciador.conectar();

		String sql = "SELECT * FROM insumocategorias";
		Statement stm = conn.createStatement();

		ResultSet rs = stm.executeQuery(sql);
		ArrayList<InsumosCategorias> InsumosCatList = new ArrayList<>();
		
		InsumosCategorias insumosCat;
		while (rs.next()) {
			insumosCat = new InsumosCategorias();
			insumosCat.setCodigo(rs.getInt("codigo"));
			insumosCat.setNome(rs.getString("nome"));
			insumosCat.setStatus(rs.getInt("status"));
			
			InsumosCatList.add(insumosCat);
		}
		gerenciador.desconectar(conn);
		return InsumosCatList;
	}

	@Override
	public void excluir(Integer codigo) throws SQLException {
		Connection conn = gerenciador.conectar();

		String sql = "DELETE FROM insumocategorias WHERE codigo=?";

		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, codigo);
		pst.executeUpdate();

		gerenciador.desconectar(conn);
		
	}
	
	@Override
	public void atualizar(InsumosCategorias InsumosC) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "UPDATE insumocategorias set nome=?, status=? WHERE codigo=?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setString(1, InsumosC.getNome());
		comando.setInt(2, InsumosC.getStatus());
		comando.setInt(3, InsumosC.getCodigo());
		
		comando.executeUpdate();
		gerenciador.desconectar(conexao);
		
	}

	@Override
	public Insumo buscarPeloCodigo(Integer Codigo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
