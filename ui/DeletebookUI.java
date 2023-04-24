package kr.ac.kopo.ui;

import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class DeletebookUI extends BaseUI {

	private BookService bookservice;
	public DeletebookUI() {
		bookservice = new BookService();
	}
	BookVO book = new BookVO();
	@Override
	public void execute() throws Exception {
		System.out.println("**************************************************************");
		System.out.println("                          도서 삭제");
		System.out.println("**************************************************************");
		String ISBN = scanStr("삭제할 도서의 ISBN을 입력하세요");
		
		bookservice.deletebook(ISBN);
		
	}
}
