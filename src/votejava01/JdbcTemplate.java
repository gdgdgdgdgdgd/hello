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
		//��ü������ ������ getInstance�� ���ؼ� ��������
		//getInstance�� ȣ���ؼ� �ش�(�ڱ��ڽŸ���) instance�� ��ȯ�޵��� �ϴ� ��
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
