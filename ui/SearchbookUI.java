package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.dao.BookDAO;
import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class SearchbookUI extends BaseUI {

	private BookService bookservice;

	public SearchbookUI() {
		bookservice = new BookService();
	}

	@Override
	public void execute() throws Exception {
		System.out.println("**************************************************************");
		System.out.println("                           도서 검색");
		System.out.println("**************************************************************");

		String title = scanStr("찾으실 책의 제목을 입력하세요");
		String writer = scanStr("찾으실 책의 저자를 입력하세요");
		String publisher = scanStr("찾으실 책의 출판사를 입력하세요");

		bookservice.Searchbook(title, writer, publisher);

		BookDAO bookDAO = new BookDAO();
		List<BookVO> bookList = bookDAO.SearchBookList(title, writer, publisher);
		for (BookVO book : bookList) {
			System.out.println("현재 검색하신 도서목록입니다.");
			System.out.println("**************************************************************");
			System.out.println("제목\t저자\t출판사");
			System.out.println("----------------------------------------------");
			System.out.printf(book.getTitle() + "\t" + book.getWriter() + "\t" + book.getPublisher() + "\n");
			System.out.println("**************************************************************");
		}
	}
}
