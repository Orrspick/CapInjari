package com.injari.web.member;

public class DetailMemberDTO {
	private int uid;
	private String gender;
	private String phone;
	private String address;
	private String major;
	private String career;
	private int career_year;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public int getCareer_year() {
		return career_year;
	}
	public void setCareer_year(int career_year) {
		this.career_year = career_year;
	}
	
}
