package kr.ac.kopo.ui;

import kr.ac.kopo.service.BookService;

public class ReturnBookUI extends BaseUI {

	private BookService bookservice;

	public ReturnBookUI() {
		bookservice = new BookService();
	}

	@Override
	public void execute() throws Exception {
		System.out.println("**************************************************************");
		System.out.println("                           도서 반납");
		System.out.println("**************************************************************");
		String ISBN = scanStr("반납할 도서의 ISBN을 입력하세요 : ");

		bookservice.ReturnBook(ISBN);

	}

}
