package kr.ac.kopo.ui;

import java.util.Date;

import kr.ac.kopo.service.BookService;

public class RentBookUI extends BaseUI {
	
	private BookService bookservice;
	
	public RentBookUI() {
		bookservice = new BookService();
	}
	@Override
	public void execute() throws Exception {
		Date rentDate = new Date(System.currentTimeMillis());
		System.out.println("**************************************************************");
		System.out.println("                           도서 대여");
		System.out.println("**************************************************************");
		String ISBN = scanStr("대여하고 싶은 도서의 ISBN을 입력하세요 : ");
		
		bookservice.RentBook(ISBN,rentDate);
		
	}

	
}
