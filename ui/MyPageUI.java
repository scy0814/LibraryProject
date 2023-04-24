package kr.ac.kopo.ui;

import java.util.Scanner;

public class MyPageUI extends BaseUI {

	public int menu() {
		System.out.println("**************************************************************");
		System.out.println("                         회원 페이지");
		System.out.println("**************************************************************");
		System.out.println("1.내정보");
		System.out.println("2.나의 대여목록");
		System.out.println("3.뒤로가기");
		System.out.print("원하는 항목을 선택하세요 : ");

		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();
		return type;
	}

	@Override
	public void execute() throws Exception {
		while (true) {
			int type = menu();
			IMemberUI ui = null;
			switch (type) {
			case 1:
				ui = new MyInfoUI();
				break;
			case 2:
				ui = new RentListUI();
				break;
			case 3:
				ui = new MemberPageUI();
				break;
			}
			if (ui != null) {
				ui.execute();
			} else {
				System.out.println("잘못 입력하셨습니다");
			}
		}
	}
}
