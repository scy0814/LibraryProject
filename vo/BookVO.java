package kr.ac.kopo.vo;

public class BookVO {
	
	private String ISBN;
	private String title;
	private String writer;
	private String publisher;
	private int no;
	
	public BookVO(String ISBN, String title, String writer, String publisher, int no) {
		super();
		this.ISBN = ISBN;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.no = no;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public BookVO() {
		super();
	}

	
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "BookVO [ISBN=" + ISBN + ", title=" + title + ", writer=" + writer + ", publisher=" + publisher + ", no="
				+ no + "]";
	}
}
