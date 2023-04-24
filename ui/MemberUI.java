package kr.ac.kopo.ui;

import java.util.Scanner;

public class MemberUI extends BaseUI{

	public int menu() {
		System.out.println("**************************************************************");
		System.out.println("                            도서관");
		System.out.println("**************************************************************");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 관리자로그인");
		System.out.print("원하는 항목을 선택하세요 : ");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();
		return type;
	}
	@Override
	public void execute() throws Exception {
		while(true) {
			int type = menu();
			IMemberUI ui = null;
		switch(type) {
		case 1:
			ui = new NewMemberUI();
			break;
		case 2:
			ui = new LogInUI();
			break;
		case 3:
			ui = new MasterLogInUI();
			break;
		}
		if(ui != null) {
			ui.execute();
		}else {
			System.out.println("잘못 입력하셨습니다");
		}
		}
	}
	
	
	}
	




