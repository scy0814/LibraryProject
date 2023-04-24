package kr.ac.kopo.ui;

import kr.ac.kopo.service.MemberService;

public class MyInfoUI extends BaseUI{

	private MemberService memberservice;
	
	public MyInfoUI() {
		memberservice = new MemberService();
	}
	
	@Override
	public void execute() throws Exception {
		memberservice.MyInfo();
	}

}
