package votejava01;

public class VoteDao {
	private	JdbcTemplate jdbcTemplate;
	
	public VoteDao() {
		jdbcTemplate = JdbcTemplate.getInstance(); 
	}
}