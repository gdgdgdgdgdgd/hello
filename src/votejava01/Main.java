package votejava01;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		while(true) {
			VoteDao voteDao = new VoteDao();
			List<VoteVo> ls = voteDao.selectVote();
			Scanner scan = null;
			try {
				scan = new Scanner(System.in);
				System.out.println("0. 다른음료 추가");
				for(VoteVo tmp : ls) {
					System.out.println(tmp.getNumber() + ". " + tmp.getName() + "/ 득표수 : " + tmp.getVote());
				}
				int num = scan.nextInt();
				if(num == 0) {
					//여긴 insert
					try {
						scan = new Scanner(System.in);
						System.out.print("투표에 추가할 음료를 적어주세요 : ");
						String drink = scan.next();
						voteDao.insertVote(drink);	
					}catch(InputMismatchException e) {
						System.out.println("다시 입력해 주세요");
					}
				}else if(num < 0) {
					System.out.println("다시 입력해 주세요");
				}else if(num > ls.size()) {
					System.out.println("다시 입력해 주세요");
				}else {
					while(true) {
						try {
							System.out.println("1.여기에 투표 2.취소");
							scan = new Scanner(System.in);
							int num1 = scan.nextInt();	
							if(num1 == 1) {
								VoteVo tmp1 = ls.get(num-1);
								long num2 = tmp1.getVote()+1;//득표수 조절변수
								voteDao.updateVote(num, num2);//고유번호, 득표수
								break;
							}else if(num1 == 2){
								break;
							}else {
								System.out.println("다시 입력해 주세요.");
							}
						}catch(InputMismatchException e) {
							System.out.println("다시 입력해 주세요.");
						}
					}
				}
			}catch(InputMismatchException e) {
				System.out.println("다시 입력해 주세요.");
			}
		}
		
		
	}

}