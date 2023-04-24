package kr.ac.kopo.service;

import java.util.Date;

import kr.ac.kopo.dao.BookDAO;
import kr.ac.kopo.vo.BookVO;

public class BookService {

	private BookDAO bookDao;
	
	public BookService() {
		bookDao = new BookDAO();
	}
	public void addbook(BookVO book){
		bookDao.addbook(book);
	}
	
	public void deletebook(String ISBN) {
		bookDao.deletebook(ISBN);
	}
	
	public void Searchbook(String title,String writer,String publisher) {
		bookDao.SearchBookList(title, writer,publisher);
		
		
	}
	
	public void RentBook(String ISBN, Date rentDate) {
		bookDao.RentBook(ISBN, rentDate);
	}
	
	public void ReturnBook(String ISBN) {
		bookDao.ReturnBook(ISBN);
	}
	
	public void RentList() {
		bookDao.RentList();
	}
	
}
