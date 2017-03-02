package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private Connection conn;
	
	public Conexao()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "aluno",
					"aluno");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(conn != null)
		{
			System.out.println("Conected");
		}
		else
		{
			System.out.println("Failed");
		}
		
	}
	
	public Connection getConexao()
	{
		return conn;
	}
	
}
