package aula20160912.conexaoBancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
	
	public static void main(String[] args) {
		
		try {
			Connection conn = DriverManager.
					getConnection("jdbc:postgresql://127.0.0.1:5432/3es2016","postgres","unicesumar");
			
			createTablePessoa(conn);
			
			insertCemMilPessoas(conn);
			
			listarMediaIdadePessoas(conn);
			
			System.out.println("Foi!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	private static void listarMediaIdadePessoas(Connection conn) throws SQLException {
		ResultSet resultado = conn.createStatement().executeQuery(
				"select "
				+ " idade%2 as parImpar, avg(idade) as media "
				+ " from pessoa"
				+ " group by idade%2");
		while (resultado.next()) {
			System.out.println("A média das idades " + (resultado.getString("parImpar")) +" é: " + (resultado.getBigDecimal("media")));
			
		}
	}

	private static void insertCemMilPessoas(Connection conn) throws SQLException {
		long horaInicio = System.currentTimeMillis();
		PreparedStatement insert = conn.prepareStatement("insert into pessoa (id, nome, idade) values (?,?,?)");
		for (int i = 1; i <= 100000; i++) {
			insert.setInt(1, i);
			insert.setString(2, "Nome pessoa " + i);
			insert.setInt(3, i%100);
			insert.execute();
		}
		insert.close();
		System.out.println("Tempo total 1000 inserts em pessoa: " + (System.currentTimeMillis()-horaInicio) + "ms"); 
		
	}

	private static void createTablePessoa(Connection conn) throws SQLException {
		Statement createTable = conn.createStatement();
		createTable.execute(
				"create table if not exists pessoa "
				+ "("
				+ "id integer not null primary key,"
				+ "nome varchar(200) not null unique,"
				+ "idade integer not null"
				+ ")");
		
	}

}
