package votejava01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcTemplate {
	private static JdbcTemplate instance;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##voter";
	private String password = "1234";
	
	private JdbcTemplate() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static JdbcTemplate getInstance() { 
		if(instance == null) {
			instance = new JdbcTemplate();
		}
		return instance;
	}
	
	public Connection getConnetion() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
}
