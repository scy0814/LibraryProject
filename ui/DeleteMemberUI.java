package kr.ac.kopo.ui;

import kr.ac.kopo.service.MasterService;
import kr.ac.kopo.vo.MasterVO;

public class DeleteMemberUI extends BaseUI {
	private MasterService masterservice;

	public DeleteMemberUI() {
		masterservice = new MasterService();
	}
	MasterVO master = new MasterVO();
	@Override
	public void execute() throws Exception {
		System.out.println("**************************************************************");
		System.out.println("                        회원 삭제");
		System.out.println("**************************************************************");
		String id = scanStr("삭제할 회원의 id를 입력하세요");
		masterservice.DeleteMember(id);
	}

}
