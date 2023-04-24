package kr.ac.kopo.ui;

import java.util.Scanner;

import kr.ac.kopo.dao.MemberDAO;

public abstract class BaseUI implements IMemberUI{

	private Scanner sc;
	protected MemberDAO MemberDao;

	public BaseUI() {
		sc = new Scanner(System.in);
		MemberDao = new MemberDAO();
	}

	protected int scanInt(String msg) {
		System.out.println(msg);

		int num = Integer.parseInt(sc.nextLine());
		return num;
	}

	protected String scanStr(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}
}
