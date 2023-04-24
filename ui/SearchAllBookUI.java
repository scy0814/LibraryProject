package kr.ac.kopo.ui;

import kr.ac.kopo.service.MasterService;

public class SearchAllBookUI extends BaseUI{

	
	@Override
	public void execute() throws Exception {
		MasterService masterservice = new MasterService();
		masterservice.SearchAllBook();
	}
	
	

	
}
