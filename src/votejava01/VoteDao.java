package votejava01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VoteDao {
	private	JdbcTemplate jdbcTemplate;
	
	public VoteDao() {
		jdbcTemplate = JdbcTemplate.getInstance(); 
	}
	
	public List<VoteVo> selectVote() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<VoteVo> ls = new ArrayList<>();
		
		String sql = "select \"NUMBER\", \"NAME\", \"VOTE\" from \"VOTE\"";
		try {
			conn = jdbcTemplate.getConnetion();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VoteVo tmp = new VoteVo(
						rs.getLong(1),
						rs.getString("NAME"),
						rs.getLong(3));
				ls.add(tmp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return ls;
		
		
	}
	
	public void updateVote(long number, long vote) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update \"VOTE\" set \"VOTE\"=" + vote + " where \"NUMBER\"=" + number;
		
		try {
			conn = jdbcTemplate.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void insertVote(String drink) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into \"VOTE\" values(SEQ_VOTE.nextval, \'" + drink + "\', 1)";
		
		try {
			conn = jdbcTemplate.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
}