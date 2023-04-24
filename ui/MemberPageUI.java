package kr.ac.kopo.ui;

import java.util.Scanner;

public class MemberPageUI extends BaseUI{
		public int menu() {
			System.out.println("**************************************************************");
			System.out.println("                         회원 페이지");
			System.out.println("**************************************************************");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 검색");
			System.out.println("3. 도서 대여");
			System.out.println("4. 도서 반납");
			System.out.println("5. 로그아웃");
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
				ui = new MyPageUI();
				break;
			case 2:
				ui = new SearchbookUI();
				break;
			case 3:
				ui = new RentBookUI();
				break;
			case 4:
				ui = new ReturnBookUI();
				break;
			case 5:
				ui = new LogOutUI();
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

