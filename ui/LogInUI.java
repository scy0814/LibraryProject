package kr.ac.kopo.ui;

import kr.ac.kopo.service.MemberService;

public class LogInUI extends BaseUI {

	
	@Override
	public void execute() throws Exception {
		System.out.println("**************************************************************");
		System.out.println("                           로그인");
		System.out.println("**************************************************************");
		String id = scanStr("아이디를 입력하세요 : ");
		String password = scanStr("비밀번호를 입력하세요 : ");
		
		MemberService memberservice = new MemberService();
		memberservice.logIn(id,password);
	}

}

