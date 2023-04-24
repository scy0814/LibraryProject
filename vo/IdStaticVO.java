package kr.ac.kopo.vo;

public class IdStaticVO {

	public static String StaticId;
	
	public IdStaticVO(MemberVO member) {
		StaticId = member.getId();
	}
}



