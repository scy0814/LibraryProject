package kr.ac.kopo.ui;

import kr.ac.kopo.service.MasterService;
import kr.ac.kopo.vo.MasterVO;

public class NewMasterUI extends BaseUI {

	private MasterService masterservice;

	public NewMasterUI() {
		masterservice = new MasterService();
		}
	


	@Override
	public void execute() throws Exception {
		String id = scanStr("아이디를 입력하세요 : ");
		String password = scanStr("비밀번호를 입력하세요 : ");
		String password2 = scanStr("비밀번호를 한번 더 입력하세요 : ");
		while (!password.equals(password2)) {
			password2 = scanStr("입력하신 비밀번호가 같지 않습니다.비밀번호를 한번 더 입력하세요 : ");
		}
		String name = scanStr("이름을 입력하세요 : ");

		MasterVO master = new MasterVO();
		master.setId(id);
		master.setPassword(password);
		master.setName(name);

		masterservice.insertMember(master);

		

	}
}