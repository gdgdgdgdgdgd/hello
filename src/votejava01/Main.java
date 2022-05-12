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
				System.out.println("0. �ٸ����� �߰�");
				for(VoteVo tmp : ls) {
					System.out.println(tmp.getNumber() + ". " + tmp.getName() + "/ ��ǥ�� : " + tmp.getVote());
				}
				int num = scan.nextInt();
				if(num == 0) {
					//���� insert
					try {
						scan = new Scanner(System.in);
						System.out.print("��ǥ�� �߰��� ���Ḧ �����ּ��� : ");
						String drink = scan.next();
						voteDao.insertVote(drink);	
					}catch(InputMismatchException e) {
						System.out.println("�ٽ� �Է��� �ּ���");
					}
				}else if(num < 0) {
					System.out.println("�ٽ� �Է��� �ּ���");
				}else if(num > ls.size()) {
					System.out.println("�ٽ� �Է��� �ּ���");
				}else {
					while(true) {
						try {
							System.out.println("1.���⿡ ��ǥ 2.���");
							scan = new Scanner(System.in);
							int num1 = scan.nextInt();	
							if(num1 == 1) {
								VoteVo tmp1 = ls.get(num-1);
								long num2 = tmp1.getVote()+1;//��ǥ�� ��������
								voteDao.updateVote(num, num2);//������ȣ, ��ǥ��
								break;
							}else if(num1 == 2){
								break;
							}else {
								System.out.println("�ٽ� �Է��� �ּ���.");
							}
						}catch(InputMismatchException e) {
							System.out.println("�ٽ� �Է��� �ּ���.");
						}
					}
				}
			}catch(InputMismatchException e) {
				System.out.println("�ٽ� �Է��� �ּ���.");
			}
		}
		
		
	}

}