package com.bitcamp.domains;

public class MemberBean {
///				arr = (JOptionPane.showInputDialog("이름, 아이디, 비번, 주민번호, 혈액형, 키, 몸무게")).split(",");
	private String userName , userId, userPW , userBD, userBT ;
	private double height = 0.0 , weight = 0.0;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserBD() {
		return userBD;
	}
	public void setUserBD(String userBD) {
		this.userBD = userBD;
	}
	public String getUserBT() {
		return userBT;
	}
	public void setUserBT(String userBT) {
		this.userBT = userBT;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	
	@Override
	public String toString() {
		return String.format("회원정보 \n"
				+ "=====================\n"
				+ "이름 : %s \n"
				+ "아이디 : %s \n"
				+ "비번 : %s \n"
				+ "주민번호 : %s \n"
				+ "혈액형 : %s \n"
				+ "키 : %.2f \n"
				+ "몸무게 : %.2f \n", userName ,userId, userPW, userBD, userBT,height , weight );
	}
	
	
}
