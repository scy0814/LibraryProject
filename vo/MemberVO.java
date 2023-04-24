package kr.ac.kopo.vo;

public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String birthNo ;
	private String email ;
	private String phoneNo ;
	
  
	public MemberVO() {
		super();
	}

	public MemberVO(String id, String password, String name, String birthNo, String email, String phoneNo) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.birthNo = birthNo;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthNo() {
		return birthNo;
	}

	public void setBirthNo(String birthNo) {
		this.birthNo = birthNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", birthNo=" + birthNo + ", email="
				+ email + ", phoneNo=" + phoneNo + "]";
	}
	
	
}



