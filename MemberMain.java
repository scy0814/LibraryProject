package kr.ac.kopo;

import kr.ac.kopo.ui.MemberUI;

public class MemberMain {

	public static void main(String[] args) {
		
		try {
			new MemberUI().execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
