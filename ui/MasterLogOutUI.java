package kr.ac.kopo.ui;

public class MasterLogOutUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("로그아웃 되었습니다.");
		MemberUI member = new MemberUI();
		member.execute();
	}

}
