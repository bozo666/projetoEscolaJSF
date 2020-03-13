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
public class TurmaRepositorioImpl implements TurmaRepositorio {
	private GerenciadorConexao gerenciador;

	public TurmaRepositorioImpl() {
		gerenciador = new GerenciadorConexaoMysql();
	}

	@Override
	public void inserir(Turma turma) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "INSERT INTO turmas (codigo,nome,status,dtInicio,dtFim,turno,Cursos_codigo) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setString(1, turma.getCodigo());
		comando.setString(2, turma.getNome());
		comando.setInt(3, turma.getStatus());
		comando.setString(4, turma.getDtInicio());
		comando.setString(5, turma.getDtFim());
		comando.setString(6, turma.getTurno());
		comando.setInt(7, turma.getCursos_codigo());
		comando.executeUpdate();
		gerenciador.desconectar(conexao);
	}

	@Override
	public void atualizar(Turma turma) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "UPDATE turmas SET nome=?,status=?,dtInicio=?,dtFim=?,turno=?,Cursos_codigo=? WHERE codigo=?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setString(1, turma.getNome());
		comando.setInt(2, turma.getStatus());
		comando.setString(3, turma.getDtInicio());
		comando.setString(4, turma.getDtFim());
		comando.setString(5, turma.getTurno());
		comando.setInt(6, turma.getCursos_codigo());
		comando.setString(7, turma.getCodigo());
		comando.executeUpdate();
		gerenciador.desconectar(conexao);

	}

	@Override
	public void excluir(String codigo) throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "DELETE FROM turmas WHERE codigo=?";
		PreparedStatement comando = conexao.prepareStatement(comandoSql);
		comando.setString(1, codigo);
		comando.executeUpdate();
		gerenciador.desconectar(conexao);

	}

//	@Override
//	public Usuario get(String email) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public ArrayList<Turma> getAll() throws SQLException {
		Connection conexao = gerenciador.conectar();
		String comandoSql = "SELECT * FROM turmas";
		Statement comando = conexao.createStatement();
		ResultSet resultado = comando.executeQuery(comandoSql);
		ArrayList<Turma> lista = new ArrayList<>();
		while (resultado.next()) {
			Turma turma = new Turma();
			turma.setCodigo(resultado.getString("codigo"));
			turma.setNome(resultado.getString("nome"));
			turma.setStatus(resultado.getInt("status"));
			turma.setDtInicio(resultado.getString("dtInicio"));
			turma.setDtFim(resultado.getString("dtFim"));
			turma.setTurno(resultado.getString("turno"));
			turma.setCursos_codigo(resultado.getInt("Cursos_codigo"));
			lista.add(turma);

		}
		gerenciador.desconectar(conexao);
		return lista;
	}

}
