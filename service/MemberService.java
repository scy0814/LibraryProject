package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.vo.MemberVO;

public class MemberService {

private MemberDAO MemberDao;
	
	public MemberService() {
		MemberDao = new MemberDAO();
	}
	
	public void insertMember(MemberVO Member) {
		
		MemberDao.insertMember(Member);
	}
	
	public List<MemberVO> selectAll() {
		List<MemberVO> MemberList = MemberDao.selectAllMember();
		return MemberList;
	}
	
	public void logIn(String id,String password) {
		MemberDao.logIn(id,password);
	}

	public boolean isIdExist(String id) {
		
		return false;
	}
	
	public void MyInfo() {
		MemberDao.MyInfo();
	}
	
	public boolean CheckId(String id) {
		return MemberDao.CheckId(id);
	}

}


