package votejava01;

public class VoteVo {

	private long number;
	private String name;
	private long vote;
	
	
	public VoteVo() {
		
	}
	
	public VoteVo(long number, String name, long vote) {
		super();
		this.number = number;
		this.name = name;
		this.vote = vote;
	}
	
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getVote() {
		return vote;
	}
	public void setVote(long vote) {
		this.vote = vote;
	}
	
	@Override
	public String toString() {
		return "VoteVo [number=" + number + ", name=" + name + ", vote=" + vote + "]";
	}

	
	
	
	
}
