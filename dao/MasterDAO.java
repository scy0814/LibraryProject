package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.ui.MasterPageUI;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.MasterVO;

public class MasterDAO {

	private MasterPageUI mp;

	public MasterDAO() {
		mp = new MasterPageUI();
	}

	public void insertMember(MasterVO master) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_master(id,password,name)");
		sql.append(" values ( ?, ?, ? ) ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, master.getId());
			pstmt.setString(2, master.getPassword());
			pstmt.setString(3, master.getName());

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("중복된 아이디입니다.");
			return;
		}
		System.out.println("회원가입을 완료하였습니다");
		// memberList.add(member);
	}

	public void MasterlogIn(String inputUsername, String inputPassword) {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM t_master WHERE id = ? AND password = ?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, inputUsername);
			pstmt.setString(2, inputPassword);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("로그인에 성공하였습니다");
				mp.execute();
			} else {
				System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SearchAllBook() {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from t_book");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			ResultSet rs = pstmt.executeQuery();
			System.out.println("현재 보유하고 있는 도서목록입니다.");
			System.out.println("**************************************************************");
			System.out.println("ISBN\t제목\t저자\t출판사\t책 권수");
			while (rs.next()) {
				String ISBN = rs.getString("ISBN");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				int no = rs.getInt("no");

				System.out.println("--------------------------------------------------------------");
				System.out.println(ISBN + "\t" + title + "\t" + writer + "\t" + publisher + "\t" + no);
			}
				System.out.println("**************************************************************");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SelectAllMember() {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from t_member");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			ResultSet rs = pstmt.executeQuery();
			System.out.println("현재 등록되어 있는 회원목록입니다.");
			System.out.println("**************************************************************");
			System.out.println("id\tpassword\tname\tbirtno\temail\tphoneno");
			while (rs.next()) {
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String birthno = rs.getString("birthno");
				String email = rs.getString("email");
				String phoneno = rs.getString("phoneno");
				System.out.println("--------------------------------------------------------------");
				System.out.println(
						id + "\t" + password + "\t" + "\t" + name + "\t" + birthno + "\t" + email + "\t" + phoneno);
			}
			System.out.println("**************************************************************");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void DeleteMember(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_member where id = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("입력하신 id의 회원이 삭제되었습니다");
			} else {
				System.out.println("입력하신 id가 없습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		SelectAllMember();
	}

}
