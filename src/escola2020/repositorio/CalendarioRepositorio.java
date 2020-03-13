package escola2020.repositorio;

import java.sql.SQLException;

import escola2020.dominio.CalendarioLetivo;


public interface CalendarioRepositorio  {
	
	public void inserir(CalendarioLetivo calendario) throws SQLException;
	
	public void atualizar(CalendarioLetivo cal) throws SQLException;
	
	public void excluir(int id) throws SQLException ;

}
