package escola2020.repositorio;


import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import escola2020.dominio.CalendarioLetivo;
import escola2020.util.GerenciadorConexao;
import escola2020.util.GerenciadorConexaoMysql;

public class CalendarioRepositorioImpl implements CalendarioRepositorio {

	private final GerenciadorConexao gerenciador = GerenciadorConexaoMysql.getInstancia();

	@Override
	public void inserir(CalendarioLetivo calendario) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "INSERT INTO calendarioletivo (imagem) VALUES (?)";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setBinaryStream(1, calendario.getFilePath());
		comando.executeUpdate();
		gerenciador.desconectar(conexao);
	}

	@Override
	public void atualizar(CalendarioLetivo calendario) throws SQLException, IOException {

		Connection conexao = gerenciador.conectar();
		String comandoSql = "UPDATE calendarioletivo set imagem=? WHERE id=?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setAsciiStream(1, calendario.getArquivo().getInputStream());
		comando.setInt(2, calendario.getId());
		comando.executeUpdate();
		gerenciador.desconectar(conexao);
	}

	@Override
	public void excluir(int id) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "DELETE FROM calendarioletivo WHERE id=?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setInt(1, id);
		comando.executeUpdate();
		gerenciador.desconectar(conexao);
	}

	

}
