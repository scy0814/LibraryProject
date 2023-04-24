package kr.ac.kopo.ui;

import kr.ac.kopo.vo.IdStaticVO;

public class LogOutUI extends BaseUI{
	
	@Override
	public void execute() throws Exception {
		System.out.println("로그아웃 되었습니다.");
		IdStaticVO.StaticId = null;
		MemberUI member = new MemberUI();
		member.execute();
	}
}
