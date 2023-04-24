package kr.ac.kopo.service;

import kr.ac.kopo.dao.MasterDAO;
import kr.ac.kopo.vo.MasterVO;

public class MasterService {

	private MasterDAO masterDao;

	public MasterService() {
		masterDao = new MasterDAO();
	}

	public void insertMember(MasterVO master) {

		masterDao.insertMember(master);
	}

	public void MasterlogIn(String inputUsername, String inputPassword) {
		masterDao.MasterlogIn(inputUsername, inputPassword);
	}

	public void SearchAllBook() {
		masterDao.SearchAllBook();
	}
	
	public void SelectAllMember() {
		masterDao.SelectAllMember();
	}
	
	public void DeleteMember(String id) {
		masterDao.DeleteMember(id);
	}

}
