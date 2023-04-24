package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.BookVO;
import kr.ac.kopo.vo.IdStaticVO;

public class BookDAO {

	public boolean bookCheck(String ISBN) {

		StringBuilder sql = new StringBuilder();

		sql.append(" select ISBN ");
		sql.append("  from t_book ");
		sql.append(" where ISBN = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, ISBN);

			int cnt = 0;
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				cnt++;
			}

			if (cnt == 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void addbook(BookVO book) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_book(ISBN,title,writer,publisher, no)");
		sql.append(" values ( ?, ?, ?, ?, ? ) ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, book.getISBN());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getWriter());
			pstmt.setString(4, book.getPublisher());
			pstmt.setInt(5, book.getNo());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("도서 등록을 완료하였습니다.");
	}

	public void deletebook(String ISBN) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_book where ISBN = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, ISBN);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("입력하신 ISBN의 도서가 삭제되었습니다");
			} else {
				System.out.println("입력하신 ISBN이 없습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<BookVO> SearchBookList(String title, String writer, String publisher) {

		List<BookVO> bookList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("select ISBN, title, writer, publisher ");
		sql.append(" from t_book ");
		sql.append(" where title = ? AND writer = ? AND publisher = ? AND ISBN IS NOT NULL");
		sql.append(" order by ISBN");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, publisher);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				title = rs.getString("title");
				writer = rs.getString("writer");
				publisher = rs.getString("publisher");

				BookVO book = new BookVO();
				book.setTitle(title);
				book.setWriter(writer);
				book.setPublisher(publisher);
				bookList.add(book);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;

	}

	public void RentBook(String ISBN, Date rentDate) {
		StringBuilder sql = new StringBuilder();
		sql.append("select ISBN, title, writer, publisher from t_book where  ISBN = ? ORDER BY ISBN");

		StringBuilder insertSql = new StringBuilder();
		insertSql.append("INSERT INTO t_rent ( id, ISBN, title, writer, publisher, rent_date) ");
		insertSql.append("VALUES (?, ?, ?, ?, ?, ?)");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				PreparedStatement insertPstmt = conn.prepareStatement(insertSql.toString());) {
			pstmt.setString(1, ISBN);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");

				insertPstmt.setString(1, IdStaticVO.StaticId);
				insertPstmt.setString(2, ISBN);
				insertPstmt.setString(3, title);
				insertPstmt.setString(4, writer);
				insertPstmt.setString(5, publisher);
				insertPstmt.setDate(6, new java.sql.Date(new java.util.Date().getTime()));
				insertPstmt.executeUpdate();

				System.out.println("대여되었습니다");
				System.out.println("--------------------------------------------------------------");
				System.out.println("ISBN: " + ISBN);
				System.out.println("도서명: " + title);
				System.out.println("저자: " + writer);
				System.out.println("출판사: " + publisher);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
				String rentDateStr = dateFormat.format(rentDate);
				System.out.println("대여 일자: " + rentDateStr);
				RentList();
			} else {
				System.out.println("입력하신 도서가 없습니다");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ReturnBook(String ISBN) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_rent where ISBN = ? ");

		StringBuilder selectSql = new StringBuilder();
		selectSql.append("select * from t_rent");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, ISBN);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("도서가 성공적으로 반납되었습니다.");
				RentList();
			} else {
				System.out.println("ISBN이 일치하지 않습니다.");
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void RentList() {
		StringBuilder sql = new StringBuilder();
		sql.append("select ISBN, title, writer, publisher, rent_date FROM t_rent WHERE id = ? ORDER BY ISBN");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, IdStaticVO.StaticId);

			ResultSet rs = pstmt.executeQuery();
			System.out.println("현재 대여중인 도서목록입니다.");
			System.out.println("**************************************************************");
			System.out.println("ISBN\t제목\t저자\t출판사\trent_date");
			while (rs.next()) {
				String ISBN = rs.getString("ISBN");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				Date rentdate = rs.getDate("rent_Date");

				System.out.println("--------------------------------------------------------------");
				System.out.println(ISBN + "\t" + title + "\t" + writer + "\t" + publisher + "\t" + rentdate);
			}
			System.out.println("**************************************************************");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
