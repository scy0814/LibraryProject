package kr.ac.kopo.ui;

import kr.ac.kopo.service.MasterService;

public class SelectAllMemberUI extends BaseUI{

	private MasterService masterservice;
	
	public SelectAllMemberUI() {
		masterservice = new MasterService();
	}
	@Override
	public void execute() throws Exception {
		
		masterservice.SelectAllMember();
	}

	
	
}
