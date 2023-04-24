package kr.ac.kopo.ui;

import kr.ac.kopo.service.BookService;

public class RentListUI extends BaseUI{

private BookService bookservice;
	
	public RentListUI() {
		bookservice = new BookService();
	}
	@Override
	public void execute() throws Exception {
		bookservice.RentList();
	}

}
