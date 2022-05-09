package votejava01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcTemplate {
	private static JdbcTemplate instance;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##tester1";
	private String password = "1234";
	
	private JdbcTemplate() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static JdbcTemplate getInstance() { 
		//객체생성은 무조건 getInstance만 통해서 생성가능
		//getInstance를 호출해서 해당(자기자신만의) instance를 반환받도록 하는 것
		//synchronized(JdbcTemplate.class) {
			if(instance == null) {
				instance = new JdbcTemplate();
			}
		//}
		return instance;
	}
	
	public Connection getConnetion() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
}
