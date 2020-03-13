package escola2020.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import escola2020.dominio.Equipamentos;
import escola2020.util.GerenciadorConexao;
import escola2020.util.GerenciadorConexaoMysql;
import java.sql.Date;
import java.time.LocalDate;


public class EquipamentoRepositorioImpl implements EquipamentoRepositorio{
private final GerenciadorConexao gerenciador = GerenciadorConexaoMysql.getInstancia();
	
	@Override
	public void inserir(Equipamentos equipamento) throws SQLException{
		Connection conexao = gerenciador.conectar();
		String comandoSql = "INSERT INTO equipamentos (codigo,numeroOrdem,nome,descricao,marca,dtAquisicao,valorCompra,status,Salas_codigo) VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setInt(1, equipamento.getCodigo());
		comando.setString(2, equipamento.getNumeroOrdem());
		comando.setString(3, equipamento.getNome());
		comando.setString(4, equipamento.getDescricao());
		comando.setString(5, equipamento.getMarca());
		comando.setString(6, equipamento.getDtAquisicao());
		comando.setDouble(7, equipamento.getValorCompra());
		comando.setInt(8, equipamento.getStatus());
		comando.setInt(9, equipamento.getSalas_codigo());
		comando.executeUpdate();
		gerenciador.desconectar(conexao);
	}
	
	@Override
	public void atualizar(Equipamentos equipamento) throws SQLException{
		
		Connection conexao = gerenciador.conectar();
		String comandoSql = "UPDATE equipamentos set numeroOrdem=?, nome=?, descricao=?, marca=?, dtAquisicao=?, valorCompra=?, status=?, Salas_codigo=? WHERE codigo=?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setString(1, equipamento.getNumeroOrdem());
		comando.setString(2, equipamento.getNome());
		comando.setString(3, equipamento.getDescricao());
		comando.setString(4, equipamento.getMarca());
		comando.setString(5, equipamento.getDtAquisicao());
		comando.setDouble(6, equipamento.getValorCompra());
		comando.setInt(7, equipamento.getStatus());
		comando.setInt(8, equipamento.getSalas_codigo());
		comando.setInt(9, equipamento.getCodigo());
		comando.executeUpdate();
		gerenciador.desconectar(conexao);
	}
	
	@Override
	public void excluir(int codigo) throws SQLException{
		Connection conexao = gerenciador.conectar();
		String comandoSql = "DELETE FROM equipamentos WHERE codigo=?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setInt(1, codigo);
		comando.executeUpdate();
		gerenciador.desconectar(conexao);
	}
	
	@Override
	public Equipamentos get(int codigo) throws SQLException{
		return null;
	}
	
	@Override
	public ArrayList<Equipamentos> getAll() throws SQLException{
		Connection conexao = gerenciador.conectar();
		String comandosql = "SELECT codigo, numeroOrdem, nome, descricao, marca, dtAquisicao, valorCompra,status,Salas_codigo FROM equipamentos ";
		Statement comando=conexao.createStatement();
		ResultSet resultado = comando.executeQuery(comandosql);
		ArrayList<Equipamentos> lista = new ArrayList<>();
		Equipamentos equipamento;
		while(resultado.next()) {
			equipamento = new Equipamentos();
			equipamento.setCodigo(resultado.getInt("codigo"));
			equipamento.setNumeroOrdem(resultado.getString("numeroOrdem"));
			equipamento.setNome(resultado.getString("nome"));
			equipamento.setDescricao(resultado.getString("descricao"));
			equipamento.setMarca(resultado.getString("marca"));
			equipamento.setDtAquisicao(resultado.getString("dtAquisicao"));
			equipamento.setValorCompra(resultado.getDouble("valorCompra"));
			equipamento.setStatus(resultado.getInt("status"));
			equipamento.setSalas_codigo(resultado.getInt("Salas_codigo"));
			lista.add(equipamento);
		}
		gerenciador.desconectar(conexao);
		return lista;
	}

	
}