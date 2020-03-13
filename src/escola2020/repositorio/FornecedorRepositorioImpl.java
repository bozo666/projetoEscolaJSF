package escola2020.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import escola2020.dominio.Fornecedor;
import escola2020.util.GerenciadorConexao;
import escola2020.util.GerenciadorConexaoMysql;

public class FornecedorRepositorioImpl implements FornecedorRepositorio{
	
	private GerenciadorConexao gerenciador;
	
	public FornecedorRepositorioImpl() {
		gerenciador = new GerenciadorConexaoMysql();
	}

	@Override
	public void inserir(Fornecedor forn) throws SQLException {
		Connection conn = gerenciador.conectar();
		
		String sql = "INSERT INTO fornecedores (nome, status) VALUES (?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, forn.getNome());
		pst.setInt(2, forn.getStatus());
		pst.executeUpdate();
		
		gerenciador.desconectar(conn);
	}

	
	@Override
	public ArrayList<Fornecedor> listarTodos() throws SQLException {
		Connection conn = gerenciador.conectar();
		
		String sql = "SELECT * FROM fornecedores";
		Statement stm = conn.createStatement();
		
		ResultSet rs = stm.executeQuery(sql);
		ArrayList<Fornecedor> fornecedorList = new ArrayList<>();
		Fornecedor forn;
		
		while(rs.next()) {
			forn = new Fornecedor();
			forn.setCodigo(rs.getInt("codigo"));
			forn.setNome(rs.getString("nome"));
			forn.setStatus(rs.getInt("status"));
			fornecedorList.add(forn);
		}
		gerenciador.desconectar(conn);
		return fornecedorList;
	}
	

	@Override
	public void excluir(Integer codigo) throws SQLException {
		Connection conn = gerenciador.conectar();

		String sql = "DELETE FROM fornecedores WHERE codigo=?";

		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, codigo);
		pst.executeUpdate();

		gerenciador.desconectar(conn);

	}
	

	@Override
	public Fornecedor buscarPeloCodigo(Integer Codigo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Fornecedor forn) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "UPDATE fornecedores set nome=?, status=? WHERE codigo=?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setString(1, forn.getNome());
		comando.setInt(2, forn.getStatus());
		comando.setInt(3, forn.getCodigo());
		
		comando.executeUpdate();
		gerenciador.desconectar(conexao);
		
	}
	
	

}
