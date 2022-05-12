package votejava01;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		VoteDao dao = new VoteDao();
		dao.updateVote(1, 5);
		dao.insertVote("ÄÝ¶ó");
		List<VoteVo> ls = dao.selectVote();
		
		for(VoteVo tmp : ls) {
			System.out.println(tmp);
		}
		
		

	}

}
