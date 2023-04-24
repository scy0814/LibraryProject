package kr.ac.kopo.ui;

import java.util.Scanner;

public class MasterPageUI extends BaseUI{

		public int menu() {
			System.out.println("**************************************************************");
			System.out.println("                        관리자 페이지");
			System.out.println("**************************************************************");
			System.out.println("1. 도서 등록");
			System.out.println("2. 도서 삭제");
			System.out.println("3. 현재 도서 목록");
			System.out.println("4. 전체 회원 목록");
			System.out.println("5. 회원 삭제");
			System.out.println("6. 로그 아웃");
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
				ui = new AddbookUI();
				break;
			case 2:
				ui = new DeletebookUI();
				break;
			case 3:
				ui = new SearchAllBookUI();
				break;
			case 4:
				ui = new SelectAllMemberUI();
				break;
			case 5:
				ui = new DeleteMemberUI();
				break;
			case 6:
				ui = new MasterLogOutUI();
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

	

