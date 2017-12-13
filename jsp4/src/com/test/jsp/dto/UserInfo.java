package com.test.jsp.dto;

public class UserInfo {
	private String userName; // 은닉
	private String userId;
	private String userPwd;
	private String userAddress;
	private int userNo;
	private int userAge;
	private int dino;
	@Override
	public String toString() {
		return "UserInfo [userName=" + userName + ", userId=" + userId + ", userPwd=" + userPwd + ", userAddress="
				+ userAddress + ", userNo=" + userNo + ", userAge=" + userAge + ", dino=" + dino + "]";
	}
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
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int i) {
		this.userNo = i;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int i) {
		this.userAge = i;
	}
	public int getDino() {
		return dino;
	}
	public void setDino(int i) {
		this.dino = i;
	}

	
}
