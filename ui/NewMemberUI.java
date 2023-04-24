package kr.ac.kopo.ui;

import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;

public class NewMemberUI extends BaseUI {

	private MemberService memberservice;

	public NewMemberUI() {
		memberservice = new MemberService();
	}

	@Override
	public void execute() throws Exception {
		System.out.println("**************************************************************");
		System.out.println("                          회원가입");
		System.out.println("**************************************************************");
		while (true) {
			String id = scanStr("아이디를 입력하세요 : ");
			
			while(!memberservice.CheckId(id)) {
		         id = scanStr("아이디가 이미 존재합니다. 다른 아이디를 입력하세요 : ");
		      }
			
				String password = scanStr("비밀번호를 입력하세요 : ");
				String password2 = scanStr("비밀번호를 한번 더 입력하세요 : ");
				while (!password.equals(password2)) {
					password2 = scanStr("입력하신 비밀번호가 같지 않습니다.비밀번호를 한번 더 입력하세요 : ");
				}
				String name = scanStr("이름을 입력하세요 : ");
				String birthNo = scanStr("생년월일을 입력하세요 : ");
				String email = scanStr("이메일을 입력하세요 : ");
				String phoneNo = scanStr("휴대폰번호를 입력하세요 : ");

				MemberVO member = new MemberVO();
				member.setId(id);
				member.setPassword(password);
				member.setName(name);
				member.setBirthNo(birthNo);
				member.setEmail(email);
				member.setPhoneNo(phoneNo);

				memberservice.insertMember(member);
				break;
			
		}
	}
}
