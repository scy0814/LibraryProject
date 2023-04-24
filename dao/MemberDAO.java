package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ui.MemberPageUI;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.IdStaticVO;
import kr.ac.kopo.vo.MemberVO;

public class MemberDAO {

//	private List<MemberVO> memberList;
//	public MemberDAO() {
//		memberList = new ArrayList<>();
//		mp = new MemberPageUI();


	public void insertMember(MemberVO member) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_member(id,password,name,birthNo,email,phoneNo )");
		sql.append(" values ( ?, ?, ?, ?, ?, ? ) ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
				
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getBirthNo());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getPhoneNo());

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("중복된 아이디입니다.");
			return;
		}
		System.out.println("회원가입을 완료하였습니다");
		System.out.println("환영합니다." + member.getId() + "님.");
		// memberList.add(member);
	}
	
	




 
		

	public void logIn(String id, String password) {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM t_member WHERE id = ? AND password = ?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				new IdStaticVO(member);
//					IdStaticVO.StaticId = member.getId();
				System.out.println("로그인에 성공하였습니다");
				MemberPageUI mp = new MemberPageUI();
//					System.out.println(IdStaticVO.StaticId);
				mp.execute();
			} else {
				System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<MemberVO> selectAllMember() {

		List<MemberVO> memberList = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select id, password, name, birthNo,email, phoneNo ");
		sql.append("  from t_member ");
		sql.append(" order by no desc ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String birthNo = rs.getString("birthNo");
				String email = rs.getString("email");
				String phoneNo = rs.getString("phoneNo");

				MemberVO member = new MemberVO();
				member.setId(id);
				member.setPassword(password);
				member.setName(name);
				member.setBirthNo(birthNo);
				member.setEmail(email);
				member.setPhoneNo(phoneNo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return memberList;
	}

	public boolean isIdExist(String id) throws Exception {
		String sql = "SELECT COUNT(*) FROM t_member WHERE id=?";
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					int count = rs.getInt(1);
					return count > 0;
				}
			}
		}
		return false;
	}
	
	public boolean CheckId(String id) {
		
		String sql = "SELECT * FROM t_member where id = ? ";
		   
	      try( 
	            Connection conn = new ConnectionFactory().getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	         ) {
	         pstmt.setString(1, id);
	         ResultSet rs = pstmt.executeQuery();
	         if(rs.next()) {
	         } else {
	            System.out.println("사용가능한 아이디 입니다. ");
	            return true;
	            }
	         
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	      return false;
	   }

	public void MyInfo() {
		System.out.println("**************************************************************");
		System.out.println("                         내정보");
		System.out.println("**************************************************************");
		System.out.println("아이디: " + IdStaticVO.StaticId);
		StringBuilder sql = new StringBuilder();
		sql.append("select * from t_member where id = ?");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, IdStaticVO.StaticId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("이름 : " + rs.getString("name"));
				System.out.println("주민등록번호 : " + rs.getString("birthno"));
				System.out.println("이메일 : " + rs.getString("email"));
				System.out.println("전화번호 : " + rs.getString("phoneNo"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

//		MemberPageUI mp = new MemberPageUI();

	}
	
	
	
	
}






