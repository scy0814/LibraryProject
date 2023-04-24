package kr.ac.kopo.ui;

import kr.ac.kopo.dao.BookDAO;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class AddbookUI extends BaseUI {

	private BookService bookservice;
	
	public AddbookUI() {
		bookservice = new BookService();
	}
	@Override
	public void execute() throws Exception {
		
		BookVO book = new BookVO();
		BookDAO bd = new BookDAO();
		System.out.println("**************************************************************");
		System.out.println("                          도서 등록");
		System.out.println("**************************************************************");
		String ISBN = scanStr("ISBN을 입력하세요 : ");
		while(!bd.bookCheck(ISBN)) {
			ISBN = scanStr("중복된 ISBN입니다 ISBN을 다시 입력하세요 : ");
		}
		String title = scanStr("제목을 입력하세요 : ");
		String writer = scanStr("저자를 입력하세요 : ");
		String publisher = scanStr("출판사를 입력하세요 : ");
		int no = scanInt("책의 개수를 입력하세요 : ");

		book.setISBN(ISBN);
		book.setTitle(title);
		book.setWriter(writer);
		book.setPublisher(publisher);
		book.setNo(no);
		
		bookservice.addbook(book);
	}

}
