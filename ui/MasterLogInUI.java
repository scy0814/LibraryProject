package kr.ac.kopo.ui;

import kr.ac.kopo.service.MasterService;

public class MasterLogInUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		String inputUsername = scanStr("아이디를 입력하세요 : ");
		String inputPassword = scanStr("비밀번호를 입력하세요 : ");
		
		MasterService masterservice = new MasterService();
		masterservice.MasterlogIn(inputUsername,inputPassword);
	}
}
